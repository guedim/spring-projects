package com.guedim.wiremock.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.guedim.wiremock.model.FraudState;
import com.guedim.wiremock.model.WebHookRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebHookClient {

	private RestTemplate restTemplate;

	WebHookClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Integer sendWebHook(Integer merchantId, String url, FraudState fraudState) {
		
		
		WebHookRequest webHookRequest = WebHookRequest.builder().merchantId(merchantId).state(fraudState).build();
				
		HttpEntity<WebHookRequest> httpEntity = new HttpEntity<>(webHookRequest);
		
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		
		log.info("getting result  [{}] for webhook notification for merchant id [{}]",result.getBody(), merchantId);
		
		return result.getStatusCode().value();
	}
}
