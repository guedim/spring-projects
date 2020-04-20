package com.guedim.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.guedim.user.User;
import com.guedim.user.UserCreateResponse;

import lombok.SneakyThrows;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;

//@Testcontainers
public class UserIntegrationTest {
    private static final Network network = Network.newNetwork();

    //@Container
    private static final GenericContainer postgres = new PostgreSQLContainer("postgres:9.6.15")
            .withDatabaseName("users")
            .withUsername("postgres")
            .withPassword("password")
            .withNetwork(network)
            .withNetworkAliases("postgres-alias");

    //@Container
    private static final GenericContainer userService = new GenericContainer("guedim-tc-demo/user:latest")
            .withExposedPorts(8083)
            .withNetwork(network)
            .withNetworkAliases("user-alias")
            .withEnv(ImmutableMap.of(
                    "SERVER_PORT", "8083",
                    "POSTGRES_URL", "jdbc:postgresql://postgres-alias:5432/users",
                    "POSTGRES_USERNAME", "postgres",
                    "POSTGRES_PASSWORD", "password"
            ))
            .dependsOn(postgres)
            .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(" --- user --- ")));

    //@Test
    void testFlow() {
        //create user
        User user = new User("", "guedim", "guedim@gmail.com");
        String userUrl = "http://" + userService.getContainerIpAddress() + ":"
                + userService.getFirstMappedPort() + "/users";
        UserCreateResponse idResponse = post(userUrl, user, UserCreateResponse.class);

        //user got some id
        assertThat(idResponse.getId(), IsNot.not(isEmptyString()));

        //get user by id
        User userResponse = new RestTemplate().getForEntity(userUrl + "/" + idResponse.getId(), User.class).getBody();
        assertThat(userResponse.getId(), equalTo(idResponse.getId()));
        assertThat(userResponse.getName(), equalTo("guedim"));
    }

    @SneakyThrows
    private <R> R post(String url, Object req, Class<R> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(req), headers);
        ResponseEntity<R> response = new RestTemplate().postForEntity(url, request, clazz);
        return response.getBody();
    }
}