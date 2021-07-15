package com.eventstore.training.scheduling.domain.writemodel.event;

import com.eventstore.training.scheduling.eventsourcing.Event;
import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class Scheduled implements Event {
  private final @NonNull String slotId;
  private final @NonNull LocalDateTime startTime;
  private final @NonNull Duration duration;
}
