package com.guedim.springbank.bankacc.cmd.api.controllers;

import com.guedim.springbank.bankacc.cmd.api.commands.DepositFundsCommand;
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
@RequestMapping(path = "/api/v1/withdrawFunds")
@Slf4j
public class WithdrawFundsController {

    private final CommandGateway commandGateway;

    @Autowired
    public WithdrawFundsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> withdrawFunds(@PathVariable(value = "id") String id,
                                                     @Valid @RequestBody WithDrawFundsCommand command) {

        try {
            command.setId(id);
            commandGateway.send(command).get();
            return new ResponseEntity<>(new BaseResponse("Withdraw successfully  completed !!!"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing request to withdraw funds for account id:" + id;
            log.error(e.toString());
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}