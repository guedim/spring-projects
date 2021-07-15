package com.eventstore.training.scheduling.infrastructure.projections;

public class DbProjector implements Subscription {
    private final Projection projection;

    public DbProjector(Projection projection) {
        this.projection = projection;
    }

    @Override
    public void project(Object event) {
        if (projection.canHandle(event)) {
            projection.handle(event);
        }
    }
}
