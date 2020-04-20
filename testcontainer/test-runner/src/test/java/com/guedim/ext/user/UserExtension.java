package com.guedim.ext.user;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import com.guedim.ext.NetworkHolder;

public class UserExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {
    private UserContainer userContainer = new UserContainer(NetworkHolder.network(), 8083);

    @Override
    public void afterAll(ExtensionContext context) {
        userContainer.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        userContainer.start();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(UserInfo.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new UserInfo(userContainer.getFirstMappedPort());
    }
}
