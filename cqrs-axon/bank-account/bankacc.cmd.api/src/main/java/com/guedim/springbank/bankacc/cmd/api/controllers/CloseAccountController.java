package com.guedim.springbank.bankacc.cmd.api.controllers;

import com.guedim.springbank.bankacc.cmd.api.commands.CloseAccountCommand;
import com.guedim.springbank.bankacc.cmd.api.commands.WithDrawFundsCommand;
import com.guedim.springbank.bankacc.core.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/closeBankAccount")
@Slf4j
public class CloseAccountController {

    private final CommandGateway commandGateway;

    @Autowired
    public CloseAccountController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> closeBankAccount(@PathVariable(value = "id") String id) {

        try {
            var command = CloseAccountCommand.builder()
                    .id(id)
                    .build();

            command.setId(id);
            commandGateway.send(command);
            return new ResponseEntity<>(new BaseResponse("Successfully close account  completed !!!"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing request to close bank account with id:" + id;
            log.error(e.toString());
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}