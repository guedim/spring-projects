package com.guedim.ext.redis;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;

public class RedisContainer extends GenericContainer<RedisContainer> {

    public RedisContainer(Network network, int port) {
        super("redis:5.0.6");
        addExposedPorts(port);
        withNetwork(network);
        withNetworkAliases("redis-alias");
        waitingFor(new HostPortWaitStrategy());
    }
}
