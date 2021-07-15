package com.eventstore.training.scheduling.eventsourcing;

import io.vavr.collection.List;

public interface EventStore {
    void appendEvents(String streamName, Long version, List<Object> events);

    List<Object> loadEvents(String streamId);
}
