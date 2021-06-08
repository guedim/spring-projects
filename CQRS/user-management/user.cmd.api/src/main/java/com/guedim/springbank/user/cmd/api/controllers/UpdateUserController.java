package com.guedim.springbank.user.cmd.api.controllers;

import com.guedim.springbank.user.cmd.api.commands.UpdateUserCommand;
import com.guedim.springbank.user.core.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/updateUser")
@Slf4j
public class UpdateUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public UpdateUserController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody UpdateUserCommand command){
        command.setId(id);
        try {
            commandGateway.sendAndWait(command);
            return new ResponseEntity<>(new BaseResponse("User successfully updated !"), HttpStatus.OK);
        } catch (Exception e) {
            var SafeErrorMessage = "Error while processing update user request for id: " + id;
            log.error(e.toString());
            return new ResponseEntity<>(new BaseResponse(SafeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
