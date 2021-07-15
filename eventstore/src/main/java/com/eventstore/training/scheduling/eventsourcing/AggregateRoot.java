package com.eventstore.training.scheduling.eventsourcing;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

public abstract class AggregateRoot {
    private Map<Class, Consumer<Object>> handlers = HashMap.empty();
    @Getter
    private List<Object> changes = List.empty();

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Long version = -1L;

    protected <T> void register(Class<T> type, Consumer<T> when) {
        handlers = handlers.put(type, (Consumer<Object>) when);
    }

    protected void raise(Object event) {
        handlers.get(event.getClass()).get().accept(event);
        changes = changes.append(event);
    }

    public void load(List<Object> events) {
        events.forEach(event -> {
            raise(event);
            version = version + 1;
        });
    }

    public void clearChanges() {
        changes = List.empty();
    }
}
