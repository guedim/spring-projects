
//package com.eventstore.training.scheduling.eventsourcing;
//
//import io.vavr.collection.List;
//import lombok.val;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class EventStreamSubscription {
//  private final Logger logger = LoggerFactory.getLogger(getClass());
//  private final List<Projection> handlers;
//  private final EventStore eventStore;
//  private final String category;
//
//  public EventStreamSubscription(List<Projection> handlers, EventStore eventStore, String category) {
//    this.handlers = handlers;
//    this.eventStore = eventStore;
//    this.category = category;
//  }
//
//  public void run() {
//    new Thread(this::consumeEvents).start();
//  }
//
//  private void consumeEvents() {
//    long lastReadPosition = -1L;
//    do {
//      val newEvents = eventStore.loadEvents("$ce-"+category, lastReadPosition + 1L);
//
//      if (newEvents.nonEmpty()) {
//        newEvents.forEach(
//            envelope -> {
//              logger.info(
//                  "Handling event: {}, with metadata: {}", envelope.event, envelope.metadata);
//              handlers.forEach(
//                  handler -> handler.handle(envelope.getEvent(), envelope.getMetadata()));
//            });
//
//        lastReadPosition = newEvents.last().getMetadata().getPosition();
//      } else {
//        try {
//          Thread.sleep(100L);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//    } while (true);
//  }
//}
