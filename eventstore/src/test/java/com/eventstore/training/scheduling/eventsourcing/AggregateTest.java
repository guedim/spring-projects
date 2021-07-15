package com.eventstore.training.scheduling.eventsourcing;

import com.eventstore.training.scheduling.infrastructure.commands.CommandHandler;
import com.eventstore.training.scheduling.infrastructure.commands.CommandHandlerMap;
import com.eventstore.training.scheduling.infrastructure.commands.Dispatcher;
import io.vavr.collection.List;
import lombok.SneakyThrows;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AggregateTest<A extends AggregateRoot> {
    private Dispatcher dispatcher;
    protected final AggregateStore aggregateStore;
    private final AggregateRoot aggregate;
    private Throwable exception;

    protected abstract AggregateRoot newInstance();

    public AggregateTest() {
        aggregate = newInstance();
        aggregateStore = new FakeAggregateStore(aggregate);
    }

    public <CH extends CommandHandler> void registerHandlers(CH commandHandler) {
        dispatcher = new Dispatcher(new CommandHandlerMap(commandHandler));
    }

    protected void given(Object... events) {
        exception = null;
        aggregate.load(List.of(events));
    }

    protected void when(Object command) {
        try {
            aggregate.clearChanges();
            dispatcher.dispatch(command);
        } catch (Throwable e) {
            exception = e;
        }
    }

    @SneakyThrows
    protected void then(Consumer<List<Object>> events) {
        if (exception != null) {
            throw exception;
        }

        events.accept(aggregate.getChanges());
    }

    protected <E extends Throwable> void then(Class<E> clazz) {
        assertEquals(clazz, exception.getClass());
    }
}
