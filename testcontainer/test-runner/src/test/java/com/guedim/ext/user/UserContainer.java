package com.guedim.ext.user;

import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;

public class UserContainer extends GenericContainer<UserContainer> {

    public UserContainer(Network network, int port) {
        super("guedim-tc-demo/user:latest");
        addExposedPorts(port);
        withNetwork(network);
        withNetworkAliases("user-alias");
        waitingFor(new HostPortWaitStrategy());

        addEnv("SERVER_PORT", port + "");
        addEnv("POSTGRES_URL", "jdbc:postgresql://postgres-alias:5432/users");
        addEnv("POSTGRES_USERNAME", "postgres");
        addEnv("POSTGRES_PASSWORD", "password");

        withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(" --- user --- ")));
    }
}
