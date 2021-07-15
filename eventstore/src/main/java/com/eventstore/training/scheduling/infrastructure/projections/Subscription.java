package com.eventstore.training.scheduling.infrastructure.projections;

public interface Subscription {
    void project(Object event);
}
