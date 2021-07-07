package com.guedim.springbank.bankacc.query.api.repositories;

import com.guedim.springbank.bankacc.core.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<BankAccount, String> {
}
