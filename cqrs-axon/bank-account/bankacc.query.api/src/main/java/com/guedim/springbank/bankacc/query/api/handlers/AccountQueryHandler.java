package com.guedim.springbank.bankacc.query.api.handlers;

import com.guedim.springbank.bankacc.query.api.dto.AccountLookupResponse;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountByHolderIdQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountByIdQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountsWithBalanceQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAllAccountsQuery;

public interface AccountQueryHandler {

    AccountLookupResponse findAccountById(FindAccountByIdQuery query);

    AccountLookupResponse findAccountByHolderId(FindAccountByHolderIdQuery query);

    AccountLookupResponse findAllAccounts(FindAllAccountsQuery query);

    AccountLookupResponse findAccountsWithBalanceQuery(FindAccountsWithBalanceQuery query);
}
