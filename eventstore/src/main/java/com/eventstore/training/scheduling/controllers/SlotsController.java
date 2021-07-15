package com.eventstore.training.scheduling.controllers;

import com.eventstore.training.scheduling.domain.writemodel.command.Book;
import com.eventstore.training.scheduling.domain.writemodel.command.Cancel;
import com.eventstore.training.scheduling.domain.writemodel.command.Schedule;
import com.eventstore.training.scheduling.infrastructure.commands.Dispatcher;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/slots")
class SlotsController {
    @Autowired
    private Dispatcher dispatcher;

    @PostMapping
    public ResponseEntity<?> schedule(@RequestBody PostSchedule schedule) {
        val aggregateId = schedule.startDateTime.toString();
        val command = new Schedule(aggregateId, schedule.startDateTime, schedule.duration);
        dispatcher.dispatch(command);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/slots/" + aggregateId)
                .body(null);
    }

    @PostMapping(value = "/{aggregateId}/book")
    public ResponseEntity<?> book(
            @RequestBody PostBook book,
            @PathVariable("aggregateId") String aggregateId) {
//        val command = new Book(aggregateId, book.patientId);
//
//        dispatcher.dispatch(command);

      return ResponseEntity.status(HttpStatus.OK)
              .header("Location", "/slots/" + aggregateId)
              .body(null);
    }

    @PostMapping(value = "/{aggregateId}/cancel")
    public ResponseEntity<?> cancel(
            @RequestBody PostCancel cancel,
            @PathVariable("aggregateId") String aggregateId) {
//        val command = new Cancel(aggregateId, cancel.reason, LocalDateTime.now());
//
//      dispatcher.dispatch(command);

      return ResponseEntity.status(HttpStatus.OK)
              .header("Location", "/slots/" + aggregateId)
              .body(null);
    }
}
