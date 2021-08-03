package com.guedim.ext.kafka;

import com.guedim.ext.NetworkHolder;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import org.testcontainers.utility.DockerImageName;

public class KafkaExtension implements BeforeAllCallback, AfterAllCallback {

    private final KafkaContainer container  = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"))
            .withNetworkAliases("kafka-alias")
            .withNetwork(NetworkHolder.network())
            .waitingFor(new HostPortWaitStrategy());

    @Override
    public void afterAll(ExtensionContext context) {
        container.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        container.start();
    }
}
