package com.eventstore.training.scheduling.eventsourcing;

import io.vavr.collection.List;

public abstract class State<S extends State<S>> {
  public abstract void apply(Event event);

  public void apply(List<Event> events) {
    events.forEach(this::apply);
  }
}
