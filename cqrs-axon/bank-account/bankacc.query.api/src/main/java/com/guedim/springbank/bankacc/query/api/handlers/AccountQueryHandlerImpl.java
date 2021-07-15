package com.guedim.springbank.bankacc.query.api.handlers;

import com.guedim.springbank.bankacc.core.model.BankAccount;
import com.guedim.springbank.bankacc.query.api.dto.AccountLookupResponse;
import com.guedim.springbank.bankacc.query.api.dto.EqualityType;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountByHolderIdQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountByIdQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAccountsWithBalanceQuery;
import com.guedim.springbank.bankacc.query.api.queries.FindAllAccountsQuery;
import com.guedim.springbank.bankacc.query.api.repositories.AccountRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountQueryHandlerImpl implements AccountQueryHandler {

    private AccountRepository accountRepository;

    @Autowired
    public AccountQueryHandlerImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountById(FindAccountByIdQuery query) {
        var bankAccount = accountRepository.findById(query.getId());
        var response = bankAccount.isPresent()
                ? new AccountLookupResponse("Bank Account successfully returned", bankAccount.get())
                : new AccountLookupResponse("No Bank account found for Id:" + query.getId());
        return response;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountByHolderId(FindAccountByHolderIdQuery query) {

        var bankAccount = accountRepository.findByAccountHolderId(query.getAccountHolderId());
        var response = bankAccount.isPresent()
                ? new AccountLookupResponse("Bank Account successfully returned", bankAccount.get())
                : new AccountLookupResponse("No Bank account found for holder Id:" + query.getAccountHolderId());
        return response;
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAllAccounts(FindAllAccountsQuery query) {

        var bankAccountIterator = accountRepository.findAll();
        if(!bankAccountIterator.iterator().hasNext())
            return new AccountLookupResponse("No bank account were found");

        var bankAccounts = new ArrayList<BankAccount>();
        bankAccountIterator.forEach(i -> bankAccounts.add(i));
        var count = bankAccounts.size();

        return new AccountLookupResponse("Successfully returned " + count + " bank accounts", bankAccounts);
    }

    @QueryHandler
    @Override
    public AccountLookupResponse findAccountsWithBalanceQuery(FindAccountsWithBalanceQuery query) {

        var bankAccounts = query.getEqualityType().equals(EqualityType.GREATER_THAN)
                ? accountRepository.findByBalanceGreaterThan(query.getBalance())
                : accountRepository.findByBalanceLessThan(query.getBalance());

        var response = bankAccounts != null && bankAccounts.size() > 0
                ? new AccountLookupResponse("Successfully returned " + bankAccounts.size() + " bank accounts", bankAccounts)
                : new AccountLookupResponse("No bank account were found");
    }
}
