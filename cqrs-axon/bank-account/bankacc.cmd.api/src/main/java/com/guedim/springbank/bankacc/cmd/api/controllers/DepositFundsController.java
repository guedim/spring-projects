package com.guedim.springbank.bankacc.cmd.api.controllers;

import com.guedim.springbank.bankacc.cmd.api.commands.DepositFundsCommand;
import com.guedim.springbank.bankacc.cmd.api.commands.OpenAccountCommand;
import com.guedim.springbank.bankacc.cmd.api.dto.OpenAccountResponse;
import com.guedim.springbank.bankacc.core.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/depositFunds")
@Slf4j
public class DepositFundsController {

    private final CommandGateway commandGateway;

    @Autowired
    public DepositFundsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "{/id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> depositFunds(@PathVariable(value = "id") String id,
                                                     @Valid @RequestBody DepositFundsCommand command) {

        try {
            command.setId(id);
            commandGateway.send(command);
            return new ResponseEntity<>(new BaseResponse("Successfully depost funded !!!"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing request to deposit bank account for id:" + id;
            log.error(e.toString());
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}