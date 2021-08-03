package com.guedim.user;


import com.guedim.user.config.KafkaConsumerConfig;
import com.guedim.user.config.KafkaProducerConfig;
import com.guedim.user.config.KafkaTopicConfig;
import com.guedim.user.kafka.KafkaConsumer;
import com.guedim.user.kafka.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes ={
        KafkaProducer.class,
        KafkaConsumer.class,
        KafkaProducerConfig.class,
        KafkaConsumerConfig.class,
        KafkaTopicConfig.class})
@DirtiesContext // Context is cleaned and reset between different tests
@EmbeddedKafka(
        partitions = 1,     // number of partitions used per topic
        brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class EmbeddedKafkaIntegrationTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    //@Test
    public void embeddedKafkaBroker_Producer_Consumer_Test()
            throws Exception {
        producer.send("Sending with simple KafkaProducer");
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumer.getLatch().getCount(), equalTo(0L));
        assertThat(consumer.getPayload(), containsString("KafkaProducer"));
    }
}