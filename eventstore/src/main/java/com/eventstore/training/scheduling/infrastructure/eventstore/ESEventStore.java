package com.eventstore.training.scheduling.infrastructure.eventstore;

import com.eventstore.dbclient.*;
import com.eventstore.training.scheduling.eventsourcing.EventStore;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import io.vavr.control.Try;
import lombok.SneakyThrows;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ESEventStore implements EventStore {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Streams client;
    private final EsEventSerde serde = new EsEventSerde();

    public ESEventStore(Streams client) {
        this.client = client;
    }

    @SneakyThrows
    @Override
    public void appendEvents(String streamName, Long version, List<Object> events) {
        if (events == null || events.isEmpty()) {
            return;
        }

        java.util.Iterator<EventData> preparedEvents = events.map(serde::serialise).iterator();

        if (version == -1L) {
            client.appendStream(streamName).expectedRevision(ExpectedRevision.NO_STREAM).addEvents(preparedEvents).execute().get();
        } else {
            client.appendStream(streamName).expectedRevision(ExpectedRevision.expectedRevision(version)).addEvents(preparedEvents).execute().get();
        }
    }

    @SneakyThrows
    @Override
    public List<Object> loadEvents(String streamId) {
        val result =
                Try.of(() -> client
                        .readStream(streamId).forward().fromStart().notResolveLinks().execute(4096)
                        .get()).map(ReadResult::getEvents).map(List::ofAll).getOrElse(List.empty());

        return result.map(serde::deserialise);
    }
}
