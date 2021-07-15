package com.eventstore.training.scheduling.domain.writemodel.command;

import com.eventstore.training.scheduling.eventsourcing.Command;
import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class Schedule implements Command {
  public final @NonNull String id;
  public final @NonNull LocalDateTime startTime;
  public final @NonNull Duration duration;
}
