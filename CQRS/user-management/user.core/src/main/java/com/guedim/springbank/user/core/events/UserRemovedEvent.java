package com.guedim.springbank.user.core.events;

import lombok.Builder;
import lombok.Data;

@Data
public class UserRemovedEvent {

    private String id;
}
