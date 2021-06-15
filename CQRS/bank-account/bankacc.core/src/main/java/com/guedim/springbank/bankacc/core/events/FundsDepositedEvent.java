package com.guedim.springbank.bankacc.core.events;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class FundsDepositedEvent {

    private String id;
    private double amount;
    private double balance;
}
