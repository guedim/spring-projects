package com.eventstore.training.scheduling.domain.readmodel;

import com.eventstore.training.scheduling.application.PatientSlotsProjection;
import com.eventstore.training.scheduling.domain.readmodel.patientslots.PatientSlot;
import com.eventstore.training.scheduling.domain.writemodel.event.Booked;
import com.eventstore.training.scheduling.domain.writemodel.event.Cancelled;
import com.eventstore.training.scheduling.domain.writemodel.event.Scheduled;
import com.eventstore.training.scheduling.infrastructure.projections.Projection;
import com.eventstore.training.scheduling.eventsourcing.ProjectionTest;
import com.eventstore.training.scheduling.infrastructure.inmemory.InMemoryPatientSlotsRepository;
import io.vavr.collection.List;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class PatientSlotsProjectionTest extends ProjectionTest {
  private InMemoryPatientSlotsRepository repository;
  private String patientId;
  private final LocalDateTime now = LocalDateTime.now();
  private final String slotId = now.toString();
  private final Duration tenMinutes = Duration.ofMinutes(10L);
  private Projection projection;


  protected String randomString() {
    return UUID.randomUUID().toString().replace("-", "").substring(8);
  }

  @BeforeEach
  void beforeEach() {
    repository = new InMemoryPatientSlotsRepository();
    projection = new PatientSlotsProjection(repository);
    patientId = randomString();
  }

  @Override
  protected Projection getProjection() {
    return projection;
  }

  @Test
  void shouldReturnAnEmptyListOfSlots() {
    then(List.empty(), repository.getPatientSlots(patientId));
  }

  @Test
  void shouldReturnAnEmptyListOfSlotsIfTheSlotWasScheduled() {
    val scheduled = new Scheduled(slotId, now, tenMinutes);

    given(scheduled);
    then(List.empty(), repository.getPatientSlots(patientId));
  }

//  @Test
//  void shouldReturnASlotIfWasBooked() {
//    val scheduled = new Scheduled(slotId, now, tenMinutes);
//    val booked = new Booked(scheduled.getSlotId(), patientId);
//
//    given(scheduled, booked);
//    then(
//        List.of(
//            new PatientSlot(
//                scheduled.getSlotId(),
//                scheduled.getStartTime(),
//                scheduled.getDuration(),
//                "booked")),
//        repository.getPatientSlots(patientId));
//  }
//
//  @Test
//  void shouldReturnASlotIfWasCanceled() {
//    val scheduled = new Scheduled(slotId, now, tenMinutes);
//    val booked = new Booked(scheduled.getSlotId(), patientId);
//    val cancelled = new Cancelled(scheduled.getSlotId(), randomString());
//
//    given(scheduled, booked, cancelled);
//    then(
//        List.of(
//            new PatientSlot(
//                scheduled.getSlotId(),
//                scheduled.getStartTime(),
//                scheduled.getDuration(),
//                "cancelled")),
//        repository.getPatientSlots(patientId));
//  }
//
//  @Test
//  void shouldReturnBothCancelledAndBooked() {
//    val scheduled = new Scheduled(slotId, now, tenMinutes);
//    val booked = new Booked(scheduled.getSlotId(), patientId);
//    val cancelled = new Cancelled(scheduled.getSlotId(), randomString());
//    String patientId2 = patientId + "-2";
//    val booked2 = new Booked(scheduled.getSlotId(), patientId2);
//
//    given(scheduled, booked, cancelled, booked2);
//    then(
//        List.of(
//            new PatientSlot(
//                scheduled.getSlotId(),
//                scheduled.getStartTime(),
//                scheduled.getDuration(),
//                "cancelled")),
//        repository.getPatientSlots(patientId));
//    then(
//        List.of(
//            new PatientSlot(
//                scheduled.getSlotId(),
//                scheduled.getStartTime(),
//                scheduled.getDuration(),
//                "booked")),
//        repository.getPatientSlots(patientId2));
//  }
}
