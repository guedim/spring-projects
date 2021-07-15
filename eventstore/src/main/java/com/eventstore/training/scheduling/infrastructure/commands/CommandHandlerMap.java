package com.eventstore.training.scheduling.infrastructure.commands;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.control.Option;

import java.util.function.Consumer;

public class CommandHandlerMap {
    private Map<Class<?>, Consumer<Object>> handlers = HashMap.empty();

    public CommandHandlerMap(CommandHandler ... commandHandlers) {
        List.of(commandHandlers).forEach(x -> x.getHandlers().forEach((key, value) -> {
                if (handlers.containsKey(key)) {
                    throw new DuplicateCommandHandler(key);
                } else {
                    handlers = handlers.put(key, value);
                }
            }));
    }

    public Option<Consumer<Object>> get(Object command) {
        return handlers.get(command.getClass());
    }
}
