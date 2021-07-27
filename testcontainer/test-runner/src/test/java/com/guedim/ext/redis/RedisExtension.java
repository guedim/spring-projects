package com.guedim.ext.redis;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.guedim.ext.NetworkHolder;

public class RedisExtension implements BeforeAllCallback, AfterAllCallback {

    private RedisContainer redisContainer = new RedisContainer(NetworkHolder.network(), 6379);

    @Override
    public void afterAll(ExtensionContext context) {
        redisContainer.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        redisContainer.start();
    }
}
