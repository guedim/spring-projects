package com.guedim.springbank.user.cmd.api.controllers;

import com.guedim.springbank.user.cmd.api.commands.RemoveUserCommand;
import com.guedim.springbank.user.core.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/removeUser")
@Slf4j
public class RemoveUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public RemoveUserController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> removeUser(@PathVariable(value = "id") String id){
        try {
            commandGateway.sendAndWait(new RemoveUserCommand(id));
            return new ResponseEntity<>(new BaseResponse("User successfully deleted !"), HttpStatus.OK);
        } catch (Exception e) {
            var SafeErrorMessage = "Error while processing remove user request for id: " + id;
            log.error(e.toString());
            return new ResponseEntity<>(new BaseResponse(SafeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
