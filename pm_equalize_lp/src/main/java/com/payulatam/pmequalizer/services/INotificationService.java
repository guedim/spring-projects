/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.payulatam.pmequalizer.model.EmailAttachment;
import com.payulatam.pmequalizer.model.EmailTemplateKey;
import com.payulatam.pmequalizer.model.LanguageIso639;

/**
 * Interface responsible for sending emails through Notification Service.
 *
 * @author Edson D. Morelo (david.morelo@payulatam.com)
 */
public interface INotificationService {
	
	/**
	 * Method to send an email through the notification service
	 * 
	 * @param key            the email template key
	 * @param languageIso639 template language
	 * @param vars           the variables
	 * @param attachments    email attachments
	 * @param delay          the specified delay
	 * @param reference      the notification reference
	 */
	public void sendEmail(EmailTemplateKey key, LanguageIso639 languageIso639, Map<String, Object> vars,
			List<EmailAttachment> attachments, Date delay, String reference);

}
