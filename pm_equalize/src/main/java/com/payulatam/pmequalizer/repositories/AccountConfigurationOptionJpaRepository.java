package com.payulatam.pmequalizer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.payulatam.pmequalizer.model.AccountConfigurationOption;

public interface AccountConfigurationOptionJpaRepository extends Repository<AccountConfigurationOption, String> {
	
	@Query("SELECT value FROM AccountConfigurationOption WHERE accountId = :accountId and key = 'PAYMENT_METHODS_ENABLED'")
	AccountConfigurationOption findByAccountId(@Param("accountId") Integer accountId);

}
