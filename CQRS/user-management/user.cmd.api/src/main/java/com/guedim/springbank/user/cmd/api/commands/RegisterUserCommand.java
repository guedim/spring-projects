package com.guedim.springbank.user.cmd.api.commands;

import com.guedim.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;
    private User user;
}
