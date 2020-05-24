package com.guedim.wiremock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guedim.wiremock.clients.WebHookClient;
import com.guedim.wiremock.model.FraudState;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebHookService {

	@Autowired
	private WebHookClient client;

	public Integer sendWebHook(Integer merchantId, String url, FraudState fraudState) {
		
		log.info("notified merchantId {} and to url {}", merchantId, url);
		
		Integer httpCode = client.sendWebHook(merchantId, url, fraudState);
		
		if (httpCode.equals(200)) {
			log.info("notified merchantId {} and to url {}", merchantId, url);
			return 200;
		} else {
			log.warn("error notifying merchantId {} and to url {}. Getting response code {}", merchantId, url, httpCode);
			return 500;
		}
	}
}
