package com.guedim.user;

import com.guedim.user.kafka.KafkaConsumer;
import com.guedim.user.controller.UserController;
import com.guedim.user.model.User;
import com.guedim.user.model.UserCreateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserControllerTest extends AbstractIntegrationTest {

    @Autowired
    private UserController controller;

    @Autowired
    private KafkaConsumer consumer;

    @Test
    public void testCreateGetUser() throws InterruptedException {
        UserCreateResponse response = controller.create(
                new User("", "guedim", "guedim@gmail.com"));
        assertThat(response.getId(), not(isEmptyString()));

        // Postgres asserts
        User user = controller.get(response.getId());
        assertThat(user.getName(), equalTo("guedim"));

        // Kafka asserts
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(consumer.getLatch().getCount(), equalTo(0L));
        assertThat(consumer.getPayload(), containsString("guedim"));
        assertThat(consumer.getPayload(), containsString("guedim@gmail.com"));
    }

    @Test
    public void testCreateDuplicateEmailThrows() {
        controller.create(new User("", "Matias", "matias@gmail.com"));

        assertThrows(DuplicateKeyException.class, () ->
                controller.create(new User("", "Matias", "matias@gmail.com")));
    }
}