package com.eventstore.training.scheduling.domain.writemodel;

import com.eventstore.training.scheduling.domain.writemodel.command.Book;
import com.eventstore.training.scheduling.domain.writemodel.command.Cancel;
import com.eventstore.training.scheduling.domain.writemodel.command.Handlers;
import com.eventstore.training.scheduling.domain.writemodel.command.Schedule;
import com.eventstore.training.scheduling.domain.writemodel.error.SlotAlreadyBooked;
import com.eventstore.training.scheduling.domain.writemodel.error.SlotAlreadyScheduled;
import com.eventstore.training.scheduling.domain.writemodel.error.SlotAlreadyStarted;
import com.eventstore.training.scheduling.domain.writemodel.error.SlotNotScheduled;
import com.eventstore.training.scheduling.domain.writemodel.event.Booked;
import com.eventstore.training.scheduling.domain.writemodel.event.Scheduled;
import com.eventstore.training.scheduling.eventsourcing.AggregateTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlotAggregateTest extends AggregateTest<SlotAggregate> {
    private final Clock clock = Clock.systemUTC();
    private final Duration tenMinutes = Duration.ofMinutes(10L);
    private final LocalDateTime now = LocalDateTime.now(clock);
    private final String slotId = now.toString();
    private final String patientId = "patient-1234";

    public SlotAggregateTest() {
        registerHandlers(new Handlers(aggregateStore));
    }

    @Override
    public SlotAggregate newInstance() {
        return new SlotAggregate();
    }

    // Test 1
    @Test
    void shouldBeScheduled() {
        Schedule command = new Schedule(slotId, now, tenMinutes);
        Scheduled scheduled = new Scheduled(slotId, command.startTime, command.duration);

        given();
        when(command);
        then(events -> assertEquals(scheduled, events.head()));
    }

    // Test 2
    @Test
    void shouldNotBeDoubleScheduled() {
        Scheduled scheduled = new Scheduled(slotId, now, tenMinutes);
        Schedule command = new Schedule(slotId, now, tenMinutes);

        given(scheduled);
        when(command);
        then(SlotAlreadyScheduled.class);
    }

    // Test 3
//    @Test
//    void shouldBeBooked() {
//        Scheduled scheduled = new Scheduled(slotId, now, tenMinutes);
//        val command = new Book(slotId, patientId);
//        Booked booked = new Booked(slotId, command.patientId);
//
//        given(scheduled);
//        when(command);
//        then(events -> assertEquals(booked, events.head()));
//    }

    // Test 4
//    @Test
//    void shouldBeCancelled() {
//        Scheduled scheduled = new Scheduled(slotId, now, tenMinutes);
//        Booked booked = new Booked(slotId, patientId);
//        Cancel command = new Cancel(slotId, "No longer needed", now);
//        Cancelled cancelled = new Cancelled(slotId, command.getReason());
//
//        given(scheduled, booked);
//        when(command);
//        then(events -> assertEquals(cancelled, events.head()));
//    }

    // Test 5
//    @Test
//    void shouldNotBeCancelledAfterStartTime() {
//        Scheduled scheduled = new Scheduled(slotId, now.minusHours(1), tenMinutes);
//        Booked booked = new Booked(slotId, patientId);
//
//        given(scheduled, booked);
//        when(new Cancel(slotId, "No longer needed", LocalDateTime.now(clock)));
//        then(SlotAlreadyStarted.class);
//    }


//    @Test
//    void shouldNotBeBookedIfWasNotScheduled() {
//        val command = new Book(slotId, patientId);
//
//        given();
//        when(command);
//        then(SlotNotScheduled.class);
//    }
//    @Test
//    void shouldNotBeDoubleBooked() {
//        Scheduled scheduled = new Scheduled(slotId, now, tenMinutes);
//        Booked booked = new Booked(slotId, patientId);
//        val command = new Book(slotId, patientId);
//
//        given(scheduled, booked);
//        when(command);
//        then(SlotAlreadyBooked.class);
//    }
//
//    @Test
//    void shouldBookAgainACancelledSlot() {
//        Scheduled scheduled = new Scheduled(slotId, now, tenMinutes);
//        Booked booked = new Booked(slotId, patientId);
//        Cancelled cancelled = new Cancelled(slotId, patientId);
//        Book command = new Book(slotId, patientId);
//        Booked booked2 = new Booked(slotId, command.patientId);
//
//        given(scheduled, booked, cancelled);
//        when(command);
//        then(events -> assertEquals(booked2, events.head()));
//    }
//
//
//    @Test
//    void shouldNotBeCancelledIfWasNotBooked() {
//        given(new Scheduled(slotId, now, tenMinutes));
//        when(new Cancel(slotId, "No longer needed", now));
//        then(SlotNotBooked.class);
//    }
}
