package com.eventstore.training.scheduling.eventsourcing;

public class FakeAggregateStore implements AggregateStore {
    private final AggregateRoot aggregate;

    public FakeAggregateStore(AggregateRoot aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public <T extends AggregateRoot> void save(T aggregate) {
    }

    @Override
    public <T extends AggregateRoot> T load(Class<T> clazz, String aggregateId) {
        return (T) aggregate;
    }
}
