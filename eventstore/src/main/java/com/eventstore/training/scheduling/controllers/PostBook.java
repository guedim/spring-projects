package com.eventstore.training.scheduling.controllers;

import lombok.Data;
import lombok.NonNull;

@Data
public class PostBook {
  public @NonNull String patientId;
}
