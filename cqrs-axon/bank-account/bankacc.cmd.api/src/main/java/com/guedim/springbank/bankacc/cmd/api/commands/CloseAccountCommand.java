package com.guedim.springbank.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Valid
public class CloseAccountCommand {

    @TargetAggregateIdentifier
    @NotNull
    private String id;
}
