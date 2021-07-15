package com.eventstore.training.scheduling.eventsourcing;

public interface AggregateStore {
    <T extends AggregateRoot> void save(T aggregate);
    <T extends AggregateRoot> T load(Class<T> clazz, String aggregateId);
}
