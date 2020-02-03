/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.services.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.payulatam.common.constants.ApiNotificationType;
import com.payulatam.common.exception.NotificationServiceException;
import com.payulatam.common.model.transfer.ApiAttachment;
import com.payulatam.common.model.transfer.ApiEmailNotification;
import com.payulatam.common.model.transfer.ApiEmailRecipient;
import com.payulatam.common.model.transfer.NotificationEnvelope;

import com.payulatam.pmequalizer.model.EmailAttachment;
import com.payulatam.pmequalizer.model.EmailTemplateKey;
import com.payulatam.pmequalizer.model.LanguageIso639;
import com.payulatam.pmequalizer.services.INotificationService;
import com.payulatam.producer.constants.ConfigurationKey;
import com.payulatam.producer.constants.Producer;
import com.payulatam.producer.factory.ProducerFactory;
import com.payulatam.producer.service.IMessageProducer;

/**
 * Class responsible for sending emails through Notification Service.
 *
 * @author Edson D. Morelo (david.morelo@payulatam.com)
 */
@Component
public class NotificationService implements INotificationService {

	/**
	 * The Class's logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

	/**
	 * The email recipient
	 */
	public static final String RECIPIENT = "destinatario";

	/**
	 * The cc recipient
	 */
	public static final String CC_RECIPIENT = "cc";

	/**
	 * The bcc recipient
	 */
	public static final String BCC_RECIPIENT = "bcc";

	/**
	 * The reply to
	 */
	public static final String REPLY_TO = "responderA";

	/**
	 * The NS api key
	 */
	@Value("${notification-service.apikey}")
	private String apiKey;

	/**
	 * Private key password
	 */
	@Value("${notification-service.brokers}")
	private String notificationHosts;

	/**
	 * Truststore location
	 */
	@Value("${kafka.truststore.location}")
	private String truststoreLocation;

	/**
	 * Truststore password
	 */
	@Value("${kafka.truststore.password}")
	private String truststorePassword;

	/**
	 * Keystore location
	 */
	@Value("${kafka.keystore.location}")
	private String keystoreLocation;

	/**
	 * Keystore password
	 */
	@Value("${kafka.keystore.password}")
	private String keystorePassword;

	/**
	 * Private key password
	 */
	@Value("${kafka.private.key.password}")
	private String privateKeyPassword;

	/**
	 * The notification service producer
	 */
	private IMessageProducer producer;

	/**
	 * {@inheritDoc}
	 */
	public void sendEmail(EmailTemplateKey key, LanguageIso639 languageIso639, Map<String, Object> vars,
			List<EmailAttachment> attachments, Date delay, String reference) {

		ApiEmailNotification notification = new ApiEmailNotification();

		ApiEmailRecipient recipient = getEmailRecipient(vars);

		notification.setApiKey(apiKey);
		notification.setRecipientInformation(recipient);
		notification.setVariables(vars);
		notification.setLanguage(languageIso639.name());
		notification.setNotificationKey(key.name());
		notification.setNotificationReference(reference);
		notification.setInitialProcessingDate(new Date());
		if (delay != null) {
			notification.setScheduledDate(delay);
		}

		if (CollectionUtils.isNotEmpty(attachments)) {
			notification.setAttachments(getEmailAttachments(attachments));
		}

		if (vars != null && vars.containsKey(REPLY_TO)) {
			notification.setReplyTo((String) vars.get(REPLY_TO));
		}

		NotificationEnvelope envelope = new NotificationEnvelope();
		envelope.setType(ApiNotificationType.EMAIL);
		envelope.setNotification(notification);

		sendNotification(envelope);
	}

	/**
	 * The method to get email recipients
	 * 
	 * @param vars the variables to get the recipients
	 * @return Api email recipient
	 */
	private ApiEmailRecipient getEmailRecipient(Map<String, Object> vars) {

		Validate.notEmpty(vars, "The variables should not be empty");

		ApiEmailRecipient recipient = new ApiEmailRecipient();

		if (vars.get(RECIPIENT) != null) {
			recipient.setTo(parseRecipients((String) vars.get(RECIPIENT)));
		}

		if (vars.get(CC_RECIPIENT) != null) {
			recipient.setCc(parseRecipients((String) vars.get(CC_RECIPIENT)));
		}

		if (vars.get(BCC_RECIPIENT) != null) {
			recipient.setBcc(parseRecipients((String) vars.get(BCC_RECIPIENT)));
		}

		return recipient;
	}

	/**
	 * Method to parse recipients
	 * 
	 * @param recipient the recipient to parse
	 * @return a list of String recipients
	 */
	private List<String> parseRecipients(String recipient) {

		List<String> rcpts = new ArrayList<>();

		if (StringUtils.isNotBlank(recipient)) {

			String[] recipients = StringUtils.split(recipient, ",");
			rcpts.addAll(Arrays.asList(recipients));
		}
		return rcpts;
	}

	/**
	 * Method to parse a list of attachments
	 * 
	 * @param attachments the original attachments
	 * @return a list of parsed attachments
	 */
	private List<ApiAttachment> getEmailAttachments(List<EmailAttachment> attachments) {

		List<ApiAttachment> apiAttachments = new ArrayList<>();
		for (EmailAttachment attachment : attachments) {
			ApiAttachment att = new ApiAttachment();
			att.setName(attachment.getName());
			att.setType(attachment.getMimeType().toString());
			att.setData(Base64.encodeBase64String(attachment.getContent()));
			apiAttachments.add(att);
		}
		return apiAttachments;
	}

	/**
	 * Sends a notification to Notification Service
	 * 
	 * @param envelope notification envelope
	 */
	public void sendNotification(NotificationEnvelope envelope) {
		try {
			LOGGER.debug("[NOTIFICATION-SERVICE] Beginning to send the message through the given producer.");
			getProducer().send(envelope);
			LOGGER.debug("[NOTIFICATION-SERVICE] Ended sending the message through the given producer.");
		} catch (Exception e) {
			LOGGER.error("Something went wrong while sending the notification", e);
		}
	}

	/**
	 * Method to return the producer
	 * 
	 * @throws NotificationServiceException
	 */
	private IMessageProducer getProducer() {

		if (producer == null || (!producer.getConfiguration(ConfigurationKey.URI).equals(notificationHosts))) {
			producer = ProducerFactory.getMessageProducer(Producer.KAFKA_PRODUCER);
			producer.addConfiguration(ConfigurationKey.URI, notificationHosts);
			producer.addConfiguration(ConfigurationKey.TRUSTSTORE_LOCATION, truststoreLocation);
			producer.addConfiguration(ConfigurationKey.TRUSTSTORE_PASSWORD, truststorePassword);
			producer.addConfiguration(ConfigurationKey.KEYSTORE_LOCATION, keystoreLocation);
			producer.addConfiguration(ConfigurationKey.KEYSTORE_PASSWORD, keystorePassword);
			producer.addConfiguration(ConfigurationKey.KEY_PASSWORD, privateKeyPassword);
		}

		return producer;
	}

}