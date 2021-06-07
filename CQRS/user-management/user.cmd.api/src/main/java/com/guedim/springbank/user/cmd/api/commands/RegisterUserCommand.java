package com.guedim.springbank.user.cmd.api.commands;

import com.guedim.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "no user details was supplied")
    @Valid
    private User user;
}
