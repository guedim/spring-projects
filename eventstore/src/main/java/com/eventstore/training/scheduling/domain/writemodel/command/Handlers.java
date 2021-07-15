package com.eventstore.training.scheduling.domain.writemodel.command;

import com.eventstore.training.scheduling.domain.writemodel.SlotAggregate;
import com.eventstore.training.scheduling.eventsourcing.AggregateStore;
import com.eventstore.training.scheduling.infrastructure.commands.CommandHandler;
import lombok.val;

public class Handlers extends CommandHandler {
    public Handlers(AggregateStore aggregateStore) {
        register(Schedule.class, schedule -> {
            val aggregate = aggregateStore.load(SlotAggregate.class, schedule.getId());
            aggregate.schedule(schedule.getId(), schedule.getStartTime(), schedule.getDuration());
            aggregateStore.save(aggregate);
        });
        register(Book.class, book -> {
//            val aggregate = aggregateStore.load(SlotAggregate.class, book.getId());
//            aggregate.book(book.getPatientId());
//            aggregateStore.save(aggregate);
        });
        register(Cancel.class, cancel -> {
//            val aggregate = aggregateStore.load(SlotAggregate.class, cancel.getId());
//            aggregate.cancel(cancel.getReason(), cancel.getCancellationTime());
//            aggregateStore.save(aggregate);
        });
    }
}
