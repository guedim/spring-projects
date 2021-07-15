package com.eventstore.training.scheduling.infrastructure.commands;

public class DuplicateCommandHandler extends RuntimeException {
    private final Class<?> clazz;

    public DuplicateCommandHandler(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getMessage() {
        return "A handler has already been registered for " + clazz.getName();
    }
}
