package com.eventstore.training.scheduling;

import com.eventstore.dbclient.*;
import com.eventstore.training.scheduling.application.AvailableSlotsProjection;
import com.eventstore.training.scheduling.application.PatientSlotsProjection;
import com.eventstore.training.scheduling.domain.readmodel.availableslots.AvailableSlotsRepository;
import com.eventstore.training.scheduling.domain.readmodel.patientslots.PatientSlotsRepository;
import com.eventstore.training.scheduling.domain.writemodel.command.Handlers;
import com.eventstore.training.scheduling.eventsourcing.EventStore;
import com.eventstore.training.scheduling.infrastructure.commands.CommandHandlerMap;
import com.eventstore.training.scheduling.infrastructure.commands.Dispatcher;
import com.eventstore.training.scheduling.infrastructure.eventstore.ESEventStore;
import com.eventstore.training.scheduling.infrastructure.eventstore.EsAggregateStore;
import com.eventstore.training.scheduling.infrastructure.inmemory.InMemoryAvailableSlotsRepository;
import com.eventstore.training.scheduling.infrastructure.inmemory.InMemoryPatientSlotsRepository;
import com.eventstore.training.scheduling.infrastructure.projections.DbProjector;
import com.eventstore.training.scheduling.infrastructure.projections.SubscriptionManager;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AppConfig {
    private final InMemoryAvailableSlotsRepository availableSlotsRepository;
    private final InMemoryPatientSlotsRepository patientSlotsRepository;
    private final Dispatcher dispatcher;
    private final SubscriptionManager subscriptionManager;

    public AppConfig() {
        ClientSettings setts = ConnectionString.parseOrThrow("esdb://admin:changeit@localhost:2113?tlsVerifyCert=false&tls=false");
        Streams client = Client.create(setts).streams();
        EventStore eventStore = new ESEventStore(client);
        val aggregateStore = new EsAggregateStore(eventStore);
        availableSlotsRepository = new InMemoryAvailableSlotsRepository();
        patientSlotsRepository = new InMemoryPatientSlotsRepository();
        dispatcher = new Dispatcher(new CommandHandlerMap(new Handlers(aggregateStore)));
        subscriptionManager = new SubscriptionManager(client,
                List.of(
                        new DbProjector(new AvailableSlotsProjection(availableSlotsRepository)),
                        new DbProjector(new PatientSlotsProjection(patientSlotsRepository))
                )
        );
        startSubscription();
    }

    @Bean
    public AvailableSlotsRepository availableSlotsRepository() {
        return availableSlotsRepository;
    }

    @Bean
    public Dispatcher dispatcher() {
        return dispatcher;
    }

    @Bean
    public PatientSlotsRepository patientSlotsRepository() {
        return patientSlotsRepository;
    }

    @Bean(name = "fixedThreadPool")
    public Executor fixedThreadPool() {
        return Executors.newFixedThreadPool(2);
    }

    @Async("fixedThreadPool")
    public void startSubscription() {
        subscriptionManager.start();
    }
}
