package com.guedim.springbank.user.cmd.api.aggregates;

import com.guedim.springbank.user.cmd.api.commands.RegisterUserCommand;
import com.guedim.springbank.user.cmd.api.commands.RemoveUserCommand;
import com.guedim.springbank.user.cmd.api.commands.UpdateUserCommand;
import com.guedim.springbank.user.cmd.api.security.PasswordEncoder;
import com.guedim.springbank.user.cmd.api.security.PasswordEncoderImpl;
import com.guedim.springbank.user.core.events.UserRegisteredEvent;
import com.guedim.springbank.user.core.events.UserRemovedEvent;
import com.guedim.springbank.user.core.events.UserUpdatedEvent;
import com.guedim.springbank.user.core.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class UserAggregate {

    private final PasswordEncoder passwordEncoder;

    @AggregateIdentifier
    private String id;
    private User user;

    public UserAggregate() {
        passwordEncoder = new PasswordEncoderImpl();
    }

    @CommandHandler
    public UserAggregate(RegisterUserCommand command) {
        var newUser = command.getUser();
        newUser.setId(command.getId());

        var password = newUser.getAccount().getPassword();
        passwordEncoder = new PasswordEncoderImpl();
        var hashedPasword = passwordEncoder.hashPassword(password);
        newUser.getAccount().setPassword(hashedPasword);

        var event = UserRegisteredEvent.builder()
                .id(command.getId())
                .user(newUser)
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateUserCommand command) {
        var updatedUser = command.getUser();
        updatedUser.setId(command.getId());

        var password = updatedUser.getAccount().getPassword();
        var hashedPasword = passwordEncoder.hashPassword(password);
        updatedUser.getAccount().setPassword(hashedPasword);

        var event = UserUpdatedEvent.builder()
                .id(UUID.randomUUID().toString())
                .user(updatedUser)
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(RemoveUserCommand command) {

        var event = new UserRemovedEvent();
        event.setId(command.getId());

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event) {
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event) {
        this.user = event.getUser();

    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
