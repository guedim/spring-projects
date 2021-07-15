package com.eventstore.training.scheduling.infrastructure.commands;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import lombok.Getter;

import java.util.function.Consumer;

public class CommandHandler {
    @Getter
    private Map<Class<?>, Consumer<Object>> handlers = HashMap.empty();

    protected <T> void register(Class<T> clazz, Consumer<T> handler) {
        handlers = handlers.put(clazz, (Consumer<Object>) handler);
    }
}
