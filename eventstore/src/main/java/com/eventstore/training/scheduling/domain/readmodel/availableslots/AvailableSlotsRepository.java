package com.eventstore.training.scheduling.domain.readmodel.availableslots;

import io.vavr.collection.List;

import java.time.LocalDate;

public interface AvailableSlotsRepository {
  void add(AvailableSlot slot);

  void markAsUnavailable(String slotId);

  void markAsAvailable(String slotId);

  List<AvailableSlot> getSlotsAvailableOn(LocalDate date);
}
