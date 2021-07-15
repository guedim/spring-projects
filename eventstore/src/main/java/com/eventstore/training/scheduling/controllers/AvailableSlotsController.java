package com.eventstore.training.scheduling.controllers;

import com.eventstore.training.scheduling.domain.readmodel.availableslots.AvailableSlot;
import com.eventstore.training.scheduling.domain.readmodel.availableslots.AvailableSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/slots/available")
class AvailableSlotsController {
  @Autowired private AvailableSlotsRepository repository;

  @GetMapping(value = "/{date}")
  public List<AvailableSlot> list(
      @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    return repository.getSlotsAvailableOn(date).asJava();
  }
}
