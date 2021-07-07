package com.guedim.springbank.bankacc.cmd.api.aggregates;

import com.guedim.springbank.bankacc.cmd.api.commands.CloseAccountCommand;
import com.guedim.springbank.bankacc.cmd.api.commands.DepositFundsCommand;
import com.guedim.springbank.bankacc.cmd.api.commands.OpenAccountCommand;
import com.guedim.springbank.bankacc.cmd.api.commands.WithDrawFundsCommand;
import com.guedim.springbank.bankacc.core.events.AccountClosedEvent;
import com.guedim.springbank.bankacc.core.events.AccountOpenedEvent;
import com.guedim.springbank.bankacc.core.events.FundsDepositedEvent;
import com.guedim.springbank.bankacc.core.events.FundsWithdrawnEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@NoArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
    private String id;
    private String accountHolderId;
    private double balance;

    @CommandHandler
    public AccountAggregate(OpenAccountCommand command) {
        var event = AccountOpenedEvent.builder()
                .id(command.getId())
                .accountHolderId(command.getAccountHolderId())
                .accountType(command.getAccountType())
                .creationDate(new Date())
                .openingBalance(command.getOpeningBalance())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AccountOpenedEvent event){
        this.id = event.getId();
        this.accountHolderId = event.getAccountHolderId();
        this.balance = event.getOpeningBalance();
    }

    @CommandHandler
    public void handle(DepositFundsCommand command) {
        var amount = command.getAmount();
        var event = FundsDepositedEvent.builder()
                .id(command.getId())
                .amount(command.getAmount())
                .balance(this.balance + amount)
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(FundsDepositedEvent event) {
        this.balance += event.getAmount();
    }

    @CommandHandler
    public void handle(WithDrawFundsCommand comand) {
        var amount = comand.getAmount();

        if(this.balance - amount < 0){
            throw new IllegalStateException("Withdrawl declined, Insufficient funds 1111");
        }

        var event = FundsWithdrawnEvent.builder()
                .id(comand.getId())
                .amount(comand.getAmount())
                .balance(this.balance - amount)
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(FundsWithdrawnEvent event) {
        this.balance -= event.getAmount();
    }

    @CommandHandler
    public void handle(CloseAccountCommand command) {
        var event = AccountClosedEvent.builder()
                .id(command.getId())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AccountClosedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
