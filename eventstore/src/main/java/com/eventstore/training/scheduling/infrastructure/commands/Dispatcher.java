package com.eventstore.training.scheduling.infrastructure.commands;

import lombok.val;

public class Dispatcher {
    private final CommandHandlerMap map;

    public Dispatcher(CommandHandlerMap map) {
        this.map = map;
    }

    public void dispatch(Object command) {
        val handler = map.get(command);

        if (handler.isDefined()) {
            handler.get().accept(command);
        } else {
            throw new HandlerNotFound(command);
        }
    }
}
