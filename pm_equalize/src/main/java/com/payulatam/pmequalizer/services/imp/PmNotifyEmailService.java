/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.services.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payulatam.pmequalizer.model.Account;
import com.payulatam.pmequalizer.model.CommonEmailVariables;
import com.payulatam.pmequalizer.model.EmailAttachment;
import com.payulatam.pmequalizer.model.EmailTemplateKey;
import com.payulatam.pmequalizer.model.LanguageIso639;
import com.payulatam.pmequalizer.model.PmEqualizer;
import com.payulatam.pmequalizer.repositories.AccountJpaRepository;
import com.payulatam.pmequalizer.services.INotificationService;
import com.payulatam.pmequalizer.services.IPmNotifyEmailService;

@Service
public class PmNotifyEmailService implements IPmNotifyEmailService {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PmNotifyEmailService.class);

	/**
	 * Email template key for requesting approval to remove account customization.
	 */
	private static final EmailTemplateKey EMAIL_TEMPLATE_KEY = EmailTemplateKey.HACKATHON_PAYMENTS_METHODS_EQUILIZER;

	/**
	 * Endpoint path for the landing page.
	 */
	private static final String LANDING_PAGE_ENDPOINT_PATH = "/lp";

	/**
	 * Signature parameter for the landing page.
	 */
	private static final String LANDING_PAGE_SIGNATURE_PARAMETER_KEY = "signature";

	/**
	 * The JPA repository for accounts.
	 */
	@Autowired
	private AccountJpaRepository accountJpaRepository;

	/**
	 * The notification service interface.
	 */
	@Autowired
	private INotificationService notificationService;

	/**
	 * The base URL for the landing page.
	 */
	@Value("${landing-page.url-base}")
	private String landingPageUrlBase;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyEmail(PmEqualizer pmEqualizer) {

		LOGGER.info("starting notifying email process for accountId {}", pmEqualizer.getAccountId());

		Account account = accountJpaRepository.findById(pmEqualizer.getAccountId()).get();

		Map<String, Object> emailVars = buildEmailVariablesMap(pmEqualizer, account);
		List<EmailAttachment> attachments = new ArrayList<>();
		Date delay = null;
		String reference = account.getId().toString();
		LanguageIso639 language = account.getCountry().getLanguageIso639();

		notificationService.sendEmail(EMAIL_TEMPLATE_KEY, language, emailVars, attachments, delay, reference);

	}

	/**
	 * Builds the {@link Map} with the variables needed by the Notification Service
	 * in order to send the mail.
	 * 
	 * @param pmEqualizer The {@link PmEqualizer}.
	 * @param account     The {@link Account}.
	 * @return The email variables map.
	 */
	private Map<String, Object> buildEmailVariablesMap(PmEqualizer pmEqualizer, Account account) {
		Map<String, Object> emailVariables = new HashMap<>();
		emailVariables.put(CommonEmailVariables.DESTINATION, account.getEmail());
		emailVariables.put(CommonEmailVariables.MERCHANT_NAME_EN, account.getName());
		emailVariables.put(CommonEmailVariables.COUNTRY, account.getCountry().getDescription());
		emailVariables.put(CommonEmailVariables.URL_VAR,
				getLandingPageUrl(account.getId(), pmEqualizer.getSignature()));

		return emailVariables;
	}

	/**
	 * Builds the URL of the landing page link to send in the email.
	 * 
	 * @param accountId The account ID.
	 * @param signature The landing page signature.
	 * @return The landing page URL.
	 */
	private String getLandingPageUrl(Integer accountId, String signature) {
		return new StringBuilder()
				.append(landingPageUrlBase)
				.append(LANDING_PAGE_ENDPOINT_PATH)
				.append("/")
				.append(accountId)
				.append("?")
				.append(LANDING_PAGE_SIGNATURE_PARAMETER_KEY)
				.append("=")
				.append(signature).toString();
	}

}
