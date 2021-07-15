package com.eventstore.training.scheduling.domain.readmodel.patientslots;

import io.vavr.collection.List;

public interface PatientSlotsRepository {

  void add(AvailableSlot availableSlot);

  void markAsBooked(String slotId, String patientId);

  void markAsCancelled(String slotId);

  List<PatientSlot> getPatientSlots(String patientId);
}
