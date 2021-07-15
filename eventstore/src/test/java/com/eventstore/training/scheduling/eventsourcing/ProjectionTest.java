package com.eventstore.training.scheduling.eventsourcing;

import com.eventstore.training.scheduling.infrastructure.projections.Projection;
import io.vavr.collection.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ProjectionTest {
  protected abstract Projection getProjection();

  protected void given(Event... events) {
    List.of(events).forEach(event -> getProjection().handle(event));
  }

  protected void then(Object expected, Object actual) {
    assertEquals(expected, actual);
  }
}
