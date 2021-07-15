package com.eventstore.training.scheduling.domain.readmodel.availableslots;

import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class AvailableSlot {
  private final @NonNull String slotId;
  private final @NonNull LocalDateTime startTime;
  private final @NonNull Duration duration;
}
