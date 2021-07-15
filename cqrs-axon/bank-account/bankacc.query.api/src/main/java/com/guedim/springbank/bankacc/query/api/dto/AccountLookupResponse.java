package com.guedim.springbank.bankacc.query.api.dto;

import com.guedim.springbank.bankacc.core.dto.BaseResponse;
import com.guedim.springbank.bankacc.core.model.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class AccountLookupResponse  extends BaseResponse {

    private List<BankAccount> accounts;

    public AccountLookupResponse(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public AccountLookupResponse(String message, List<BankAccount> accounts) {
        super(message);
        this.accounts = accounts;
    }

    public AccountLookupResponse(String message, BankAccount account) {
        super(message);
        this.accounts = new ArrayList<>();
        this.accounts.add(account);
    }

    public AccountLookupResponse(String s) {
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }
}
