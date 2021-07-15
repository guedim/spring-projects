package com.eventstore.training.scheduling.domain.writemodel;

import com.eventstore.training.scheduling.domain.writemodel.error.*;
import com.eventstore.training.scheduling.domain.writemodel.event.Booked;
import com.eventstore.training.scheduling.domain.writemodel.event.Cancelled;
import com.eventstore.training.scheduling.domain.writemodel.event.Scheduled;
import com.eventstore.training.scheduling.eventsourcing.AggregateRoot;

import java.time.Duration;
import java.time.LocalDateTime;

public class SlotAggregate extends AggregateRoot {
    private boolean isBooked = false;
    private boolean isScheduled = false;
    private LocalDateTime startTime = null;

    public SlotAggregate() {
        register(Booked.class, this::when);
        register(Cancelled.class, this::when);
        register(Scheduled.class, this::when);
    }

    public void schedule(String id, LocalDateTime startTime, Duration duration) {
        // raise a correct event here
        raise(new Scheduled(null, null, null));
    }

    public void cancel(String reason, LocalDateTime cancellationTime) {

    }

    public void book(String patientId) {

    }

    private boolean isStarted(LocalDateTime cancellationTime) {
        return cancellationTime.isAfter(startTime);
    }

    private void when(Booked booked) {
    }

    private void when(Cancelled cancelled) {
    }

    private void when(Scheduled scheduled) {
    }
}
