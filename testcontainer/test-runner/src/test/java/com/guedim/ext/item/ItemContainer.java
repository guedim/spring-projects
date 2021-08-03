package com.guedim.ext.item;

import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;

import java.time.Duration;

public class ItemContainer extends GenericContainer<ItemContainer> {

    public ItemContainer(Network network, int port) {
        super("guedim-tc-demo/item:latest");
        addExposedPorts(port);
        withNetwork(network);
        withNetworkAliases("item-alias");

        addEnv("SERVER_PORT", port + "");

        addEnv("USER_HOST", "user-alias");
        addEnv("user-service.host", "user-alias");
        addEnv("USER_PORT", "8083");
        addEnv("user-service.port", "8083");

        addEnv("REDIS_HOST", "redis-alias");
        addEnv("REDIS_PORT", "6379");

        HttpWaitStrategy httpWaitStrategy = new HttpWaitStrategy();
        httpWaitStrategy.withStartupTimeout(Duration.ofMinutes(1));
        waitingFor(httpWaitStrategy.forPath("/actuator/health").forStatusCode(200));

        withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(" --- item --- ")));
    }
}
