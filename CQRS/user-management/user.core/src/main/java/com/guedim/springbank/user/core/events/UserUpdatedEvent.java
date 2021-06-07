package com.guedim.springbank.user.core.events;

import com.guedim.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdatedEvent {

    private String id;
    private User user;
}
