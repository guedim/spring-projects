package com.eventstore.training.scheduling.infrastructure.eventstore;

import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.ResolvedEvent;
import com.eventstore.training.scheduling.domain.writemodel.event.Booked;
import com.eventstore.training.scheduling.domain.writemodel.event.Cancelled;
import com.eventstore.training.scheduling.domain.writemodel.event.Scheduled;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import lombok.val;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;
import static io.vavr.Predicates.is;

public class EsEventSerde {
    final ObjectMapper objectMapper = new ObjectMapper();

    public EventData serialise(Object object) {
        UUID eventId = UUID.randomUUID();
        val data = objectMapper.createObjectNode();
        return Match(object)
                .of(
                        Case(
                                $(instanceOf(Scheduled.class)),
                                scheduled -> {
                                    data.put("slotId", scheduled.getSlotId());
                                    data.put("startTime", scheduled.getStartTime().toString());
                                    data.put("duration", scheduled.getDuration().toString());
                                    return toEventData("scheduled", eventId, data);
                                }),
                        Case(
                                $(instanceOf(Booked.class)),
                                booked -> {
//                                    data.put("slotId", booked.getSlotId());
//                                    data.put("patientId", booked.getPatientId());
                                    return toEventData("booked", eventId, data);
                                }),
                        Case(
                                $(instanceOf(Cancelled.class)),
                                cancelled -> {
//                                    data.put("slotId", cancelled.getSlotId());
//                                    data.put("reason", cancelled.getReason());
                                    return toEventData("cancelled", eventId, data);
                                }));
    }

    private EventData toEventData(String eventType, UUID eventId, ObjectNode dataNode) {
        try {
            return new EventData(
                    eventId,
                    eventType,
                    "application/json",
                    objectMapper.writeValueAsBytes(dataNode),
                    objectMapper.writeValueAsBytes(objectMapper.createObjectNode()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public Object deserialise(ResolvedEvent event) {
        val data = objectMapper.readTree(event.getEvent().getEventData());
        return Match(event.getEvent().getEventType())
                .of(
                        Case(
                                $(is("scheduled")),
                                () ->
                                        new Scheduled(
                                                data.get("slotId").asText(),
                                                LocalDateTime.parse(data.get("startTime").asText()),
                                                Duration.parse(data.get("duration").asText()))),
                        Case(
                                $(is("booked")),
                                () ->
                                        new Booked(
//                                                data.get("slotId").asText(),
//                                                data.get("patientId").asText()
                                                )
                        ),
                        Case(
                                $(is("cancelled")),
                                () ->
                                        new Cancelled(
//                                                data.get("slotId").asText(),
//                                                data.get("reason").asText()
                                        )));
    }
}
