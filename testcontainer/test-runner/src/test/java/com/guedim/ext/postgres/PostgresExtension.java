package com.guedim.ext.postgres;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import com.guedim.ext.NetworkHolder;

public class PostgresExtension implements BeforeAllCallback, AfterAllCallback {

    private final GenericContainer container = new PostgreSQLContainer("postgres:9.6.15")
            .withDatabaseName("users")
            .withUsername("postgres")
            .withPassword("password")
            .withNetworkAliases("postgres-alias")
            .withNetwork(NetworkHolder.network());

    @Override
    public void afterAll(ExtensionContext context) {
        container.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        container.start();
    }
}
