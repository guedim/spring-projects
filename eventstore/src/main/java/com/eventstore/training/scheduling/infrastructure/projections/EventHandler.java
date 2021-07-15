package com.eventstore.training.scheduling.infrastructure.projections;

import lombok.Data;

import java.util.function.Consumer;

@Data
public class EventHandler {
    private final Class type;

    private final Consumer<Object> handler;
}
