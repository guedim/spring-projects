package com.guedim.springbank.bankacc.query.api.handlers;

import com.guedim.springbank.bankacc.core.events.AccountClosedEvent;
import com.guedim.springbank.bankacc.core.events.AccountOpenedEvent;
import com.guedim.springbank.bankacc.core.events.FundsDepositedEvent;
import com.guedim.springbank.bankacc.core.events.FundsWithdrawnEvent;

public interface AccountEventHandler {

    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
