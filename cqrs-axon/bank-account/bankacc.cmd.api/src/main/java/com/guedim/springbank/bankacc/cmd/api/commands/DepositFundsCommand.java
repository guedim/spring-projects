package com.guedim.springbank.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Data
@Builder
@Valid
public class DepositFundsCommand {

    @TargetAggregateIdentifier
    private String id;
    @Min(value = 1, message = "The deposit must be greater than 0")
    private double amount;
}
