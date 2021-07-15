package com.eventstore.training.scheduling.controllers;

import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class PostSchedule {
  public @NonNull LocalDateTime startDateTime;
  public @NonNull Duration duration;
}
