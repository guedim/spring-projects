package com.eventstore.training.scheduling.domain.readmodel.patientslots;

import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class PatientSlot {
  private final @NonNull String slotId;
  private final @NonNull LocalDateTime startTime;
  private final @NonNull Duration duration;
  private final @NonNull String status;
}
