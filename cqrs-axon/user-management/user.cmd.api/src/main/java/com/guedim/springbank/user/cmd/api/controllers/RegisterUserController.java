package com.guedim.springbank.user.cmd.api.controllers;

import com.guedim.springbank.user.cmd.api.commands.RegisterUserCommand;
import com.guedim.springbank.user.cmd.api.dto.RegisterUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/registerUser")
@Slf4j
public class RegisterUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterUserController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody @Valid RegisterUserCommand command){

        var id = UUID.randomUUID().toString();
        command.setId(id);

        try {
            commandGateway.sendAndWait(command);
            return new ResponseEntity<>(new RegisterUserResponse(id,"User successfully registered !"), HttpStatus.CREATED);
        } catch (Exception e) {
            var SafeErrorMessage = "Error while processing register user request for id: " + id;
            log.error(e.toString());
            return new ResponseEntity<>(new RegisterUserResponse(id, SafeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
