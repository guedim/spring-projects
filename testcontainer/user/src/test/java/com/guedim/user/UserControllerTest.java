package com.guedim.user;

import com.guedim.user.config.KafkaConsumer;
import com.guedim.user.config.KafkaProducer;
import com.guedim.user.controller.UserController;
import com.guedim.user.model.User;
import com.guedim.user.model.UserCreateResponse;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Import(KafkaTestContainersConfiguration.class)
@Testcontainers
public class UserControllerTest {

    @Autowired
    private UserController controller;




    @Test
    public void testCreateGetUser() {
        UserCreateResponse response = controller.create(
                new User("", "guedim", "guedim@gmail.com"));
        assertThat(response.getId(), not(isEmptyString()));

        User user = controller.get(response.getId());
        assertThat(user.getName(), equalTo("guedim"));
    }

    @Test
    public void testCreateDuplicateEmailThrows() {
        controller.create(new User("", "Matias", "matias@gmail.com"));

        assertThrows(DuplicateKeyException.class, () ->
                controller.create(new User("", "Matias", "matias@gmail.com")));
    }





    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @Test
    public void givenKafkaDockerContainer_whenSendingtoSimpleProducer_thenMessageReceived() throws Exception {
        producer.send("Sending with own controller");
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumer.getLatch().getCount(), equalTo(0L));
        assertThat(consumer.getPayload(), containsString("embedded-user-topic"));
    }
}