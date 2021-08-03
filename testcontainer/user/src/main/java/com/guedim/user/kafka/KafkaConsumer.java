package com.guedim.user.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private String payload = null;

    @KafkaListener(topics = "${user.topic}", groupId = "${user.group}")
    public void receive(String payload) {
        log.info("received payload='{}'", payload);
        setPayload(payload);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    private void setPayload(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}