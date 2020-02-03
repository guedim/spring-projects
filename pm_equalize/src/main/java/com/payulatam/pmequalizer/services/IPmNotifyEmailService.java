/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.services;

import com.payulatam.pmequalizer.model.PmEqualizer;
import com.payulatam.pmequalizer.services.imp.NotificationService;

/**
 * Interface responsible for collecting the information necessary to send the
 * approval request via email, and request send it to the
 * {@link NotificationService}.
 *
 * @author Edson D. Morelo (david.morelo@payulatam.com)
 */
public interface IPmNotifyEmailService {
	
	/**
	 * Collects the information necessary to send the approval request via email,
	 * and request to the {@link NotificationService} send it.
	 */
	void notifyEmail(PmEqualizer pmEqualizer);

}
