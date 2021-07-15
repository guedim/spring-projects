package com.guedim.springbank.bankacc.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Data
@Builder
@Valid
public class WithDrawFundsCommand {

    @TargetAggregateIdentifier
    private String id;
    @Min(value = 1, message = "Withdraw value must be greater than 0")
    private double amount;

}
