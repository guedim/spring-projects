package com.guedim.ext.item;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import com.guedim.ext.NetworkHolder;

public class ItemExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {
    private ItemContainer itemContainer = new ItemContainer(NetworkHolder.network(), 8084);

    @Override
    public void afterAll(ExtensionContext context) {
        itemContainer.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        itemContainer.start();
    }


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(ItemInfo.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new ItemInfo(itemContainer.getFirstMappedPort());
    }
}
