package com.guedim.ext.item;

import com.guedim.ext.NetworkHolder;
import org.junit.jupiter.api.extension.*;

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
