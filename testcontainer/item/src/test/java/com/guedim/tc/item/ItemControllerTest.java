package com.guedim.tc.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guedim.tc.item.config.UserProperties;
import com.guedim.tc.item.controller.ItemController;
import com.guedim.tc.item.model.Item;
import com.guedim.tc.item.model.ItemCreateResponse;
import com.guedim.tc.item.model.ItemResponse;
import com.guedim.tc.item.model.User;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.net.URI;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
@ContextConfiguration(initializers = {ItemControllerTest.PropertiesInitializer.class})
@Testcontainers
public class ItemControllerTest {

    @Container
    static GenericContainer redis = new GenericContainer("redis:5.0.6")
            .withExposedPorts(6379);

    static class PropertiesInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.redis.host=localhost",
                    "spring.redis.port=" + redis.getFirstMappedPort()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Autowired
    private ItemController controller;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserProperties userProps;


    private MockRestServiceServer mockServer;

    @BeforeEach
    void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testCreateItem() {
        String userId = UUID.randomUUID().toString();
        mockUser(userId);

        ItemCreateResponse response = controller.create(new Item("", "T-shirt", "XS", userId));
        assertThat(response.getId(), not(isEmptyString()));

        ItemResponse item = controller.get(response.getId());
        assertThat(item.getCategory(), equalTo("T-shirt"));
        assertThat(item.getUser().getName(), equalTo("guedim"));

        mockServer.verify();
    }

    @SneakyThrows
    private void mockUser(String id) {
        User user = new User(id, "guedim", "guedim@gmail.com");
        String url = "http://" + userProps.getHost() + ":" + userProps.getPort();

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(url + "/users/" + id)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ObjectMapper().writeValueAsString(user))
                );
    }
}