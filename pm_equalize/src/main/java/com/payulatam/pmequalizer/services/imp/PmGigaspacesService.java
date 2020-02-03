package com.payulatam.pmequalizer.services.imp;

import static java.util.Objects.nonNull;

import javax.annotation.PostConstruct;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.gigaspaces.client.WriteModifiers;
import com.j_spaces.core.IJSpace;
import com.payulatam.pmequalizer.model.AccountConfigurationOption;
import com.payulatam.pmequalizer.model.AccountConfigurationOptionKey;
import com.payulatam.pmequalizer.services.IPmGigaspacesService;

import net.jini.core.lease.Lease;



@Service
public class PmGigaspacesService implements IPmGigaspacesService  {
	
	private final Logger LOG = LoggerFactory.getLogger(IPmGigaspacesService.class);

	private GigaSpace gigaSpace;
	
	private static final long TIMEOUT = 5000;

	@Value("${gigaspaces.account-space-url:jini://*/*/accountSpace?locators=payuapp01:7102,payuapp02:7102,payuapp03:7102}")
	private String URL_ACCOUNT_SPACE;

	@Override
	public void equalizeSpace(Integer accountId) {
		
		try {
			// find accountConfigOption
			AccountConfigurationOption option = findAccountConfigurationOption(accountId);
			// update accountConfigOption
			updateAccountConfigurationOption(option);
		} catch(Exception e) {
			LOG.error("error updating accountSpace for accountId {}", accountId, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	private AccountConfigurationOption findAccountConfigurationOption(Integer accountId) {
		
		Assert.isTrue(isConnected(),"Gigaspaces not connected");
		Assert.notNull(accountId,"accountId must not be null");

		
		final AccountConfigurationOption template = new AccountConfigurationOption();
		template.setAccountId(accountId);
		template.setKey(AccountConfigurationOptionKey.PAYMENT_METHODS_ENABLED);
		
		LOG.info("finding accountConfigurtionOption into space for accountId {}", accountId);
		AccountConfigurationOption accountConfigurationOption = gigaSpace.read(template, TIMEOUT);;
		accountConfigurationOption.setValue(org.apache.commons.lang.StringUtils.EMPTY);
		
		return accountConfigurationOption; 
	}
	
	/**
	 * 
	 * @param option
	 */
	private void updateAccountConfigurationOption(AccountConfigurationOption option) {
		LOG.info("updating accountConfigurtionOption for accountId {}", option.getAccountId());
		//gigaSpace.write(option, Lease.FOREVER, TIMEOUT, WriteModifiers.UPDATE_OR_WRITE);
	}
	
	
	/**
	 * It returns a {@code GigaSpace} connected with the space specified in the {@code url}.
	 *
	 * @return Gigaspace object to execute operations over a specific space
	 */
	// @PostConstruct
	private void connectSpace(){
		LOG.info("Trying to connect: {}", URL_ACCOUNT_SPACE);
		IJSpace space = new UrlSpaceConfigurer(URL_ACCOUNT_SPACE).space();
		gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();
	}
	
	/**
	 * It validates if already exist {@link org.openspaces.core.GigaSpace} instance.
	 *
	 * @return true if it is connected to space
	 */
	private boolean isConnected(){
		return nonNull(gigaSpace);
	}


}
