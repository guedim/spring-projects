package com.guedim.debezium.listener;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import org.springframework.stereotype.Component;

import com.guedim.debezium.elasticsearch.service.StudentService;
import com.guedim.debezium.utils.Operation;

import io.debezium.config.Configuration;
import io.debezium.embedded.EmbeddedEngine;
import lombok.extern.slf4j.Slf4j;

import static io.debezium.data.Envelope.FieldName.*;
import static java.util.stream.Collectors.toMap;

@Slf4j
@Component
public class CDCListener {

    /**
     * Single thread pool which will run the Debezium engine asynchronously.
     */
    private final Executor executor = Executors.newSingleThreadExecutor();

    /**
     * The Debezium engine which needs to be loaded with the configurations, Started and Stopped - for the
     * CDC to work.
     */
    private final EmbeddedEngine engine;

    /**
     * Handle to the Service layer, which interacts with ElasticSearch.
     */
    private final StudentService studentService;

    /**
     * Constructor which loads the configurations and sets a callback method 'handleEvent', which is invoked when
     * a DataBase transactional operation is performed.
     *
     * @param studentConnector
     * @param studentService
     */
    private CDCListener(Configuration studentConnector, StudentService studentService) {
        this.engine = EmbeddedEngine
                .create()
                .using(studentConnector)
                .notifying(this::handleEvent).build();

        this.studentService = studentService;
    }

    /**
     * The method is called after the Debezium engine is initialized and started asynchronously using the Executor.
     */
    @PostConstruct
    private void start() {
        this.executor.execute(engine);
    }

    /**
     * This method is called when the container is being destroyed. This stops the debezium, merging the Executor.
     */
    @PreDestroy
    private void stop() {
        if (this.engine != null) {
            this.engine.stop();
        }
    }

    /**
     * This method is invoked when a transactional action is performed on any of the tables that were configured.
     *
     * @param sourceRecord
     */
    private void handleEvent(SourceRecord sourceRecord) {
        Struct sourceRecordValue = (Struct) sourceRecord.value();

        if(sourceRecordValue != null) {
            Operation operation = Operation.getOperation((String) sourceRecordValue.get(OPERATION));

            //Only if this is a transactional operation.
            if(operation != Operation.READ) {

                Map<String, Object> message;               
                //Build a map with all row data received.
                Struct struct = (Struct) sourceRecordValue.get(operation.getRecord());
                message = struct.schema().fields().stream()
                        .map(Field::name)
                        .filter(fieldName -> struct.get(fieldName) != null)
                        .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
                        .collect(toMap(Pair::getKey, Pair::getValue));

                //Call the service to handle the data change.
                studentService.maintainReadModel(message, operation);
                log.info("Data Changed: {} with Operation: {}", message, operation.name());
            }
        }
    }
}
