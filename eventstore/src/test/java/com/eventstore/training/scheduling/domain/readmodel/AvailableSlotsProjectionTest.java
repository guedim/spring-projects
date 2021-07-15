package com.eventstore.training.scheduling.domain.readmodel;

import com.eventstore.training.scheduling.application.AvailableSlotsProjection;
import com.eventstore.training.scheduling.domain.readmodel.availableslots.AvailableSlot;
import com.eventstore.training.scheduling.domain.writemodel.event.Booked;
import com.eventstore.training.scheduling.domain.writemodel.event.Cancelled;
import com.eventstore.training.scheduling.domain.writemodel.event.Scheduled;
import com.eventstore.training.scheduling.infrastructure.projections.Projection;
import com.eventstore.training.scheduling.eventsourcing.ProjectionTest;
import com.eventstore.training.scheduling.infrastructure.inmemory.InMemoryAvailableSlotsRepository;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AvailableSlotsProjectionTest extends ProjectionTest {
  private InMemoryAvailableSlotsRepository repository;
  private final LocalDateTime now = LocalDateTime.now();
  private final String slotId = now.toString();
  private final Duration tenMinutes = Duration.ofMinutes(10L);

  private Projection projection;

  protected String randomString() {
    return UUID.randomUUID().toString().replace("-", "").substring(8);
  }

  @Override
  protected Projection getProjection() {
    return projection;
  }

  @BeforeEach
  void beforeEach() {
    repository = new InMemoryAvailableSlotsRepository();
    projection = new AvailableSlotsProjection(repository);
  }

  @Test
  void shouldAddSlotToTheList() {
    val scheduled = new Scheduled(slotId, now, tenMinutes);

    given(scheduled);
    then(
        List.of(
            new AvailableSlot(
                scheduled.getSlotId(), scheduled.getStartTime(), scheduled.getDuration())),
        repository.getSlotsAvailableOn(LocalDate.now()));
  }

//  @Test
//  void shouldRemoveSlotFromTheListIfItWasBooked() {
//    val scheduled = new Scheduled(slotId, now, tenMinutes);
//    val booked = new Booked(scheduled.getSlotId(), randomString());
//
//    given(scheduled, booked);
//    then(List.empty(), repository.getSlotsAvailableOn(LocalDate.now()));
//  }
//
//  @Test
//  void shouldAddSlotAgainIfBookingWasCancelled() {
//    val scheduled = new Scheduled(slotId, now, tenMinutes);
//    val booked = new Booked(scheduled.getSlotId(), randomString());
//    val cancelled = new Cancelled(scheduled.getSlotId(), randomString());
//
//    given(scheduled, booked, cancelled);
//    then(
//        List.of(
//            new AvailableSlot(
//                scheduled.getSlotId(), scheduled.getStartTime(), scheduled.getDuration())),
//        repository.getSlotsAvailableOn(LocalDate.now()));
//  }
}
