package com.guedim.user;

import com.guedim.user.controller.UserController;
import com.guedim.user.model.User;
import com.guedim.user.model.UserCreateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ContextConfiguration(initializers = {UserControllerTest.PropertiesInitializer.class})
@Testcontainers
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Container
    private static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:9.6.15")
            .withDatabaseName("users")
            .withUsername("postgres")
            .withPassword("password");

    static class PropertiesInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

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
}