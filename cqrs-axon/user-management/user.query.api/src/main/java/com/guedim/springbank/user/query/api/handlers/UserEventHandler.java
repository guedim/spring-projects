package com.guedim.springbank.user.query.api.handlers;

import com.guedim.springbank.user.core.events.UserRegisteredEvent;
import com.guedim.springbank.user.core.events.UserRemovedEvent;
import com.guedim.springbank.user.core.events.UserUpdatedEvent;

public interface UserEventHandler {

    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);

}
