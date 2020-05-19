package com.guedim.wiremock.clients;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.guedim.wiremock.model.FraudRequest;
import com.guedim.wiremock.model.FraudResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FraudEvaluationClient {

	@Value("${app.config-service.base-path:https://fraudEvaluation.org/evaluate}")
	private String baseUrl;

	private RestTemplate restTemplate;

	FraudEvaluationClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public FraudResponse evaluate(Integer merchantId, BigDecimal value) {
		
		FraudRequest request =  FraudRequest.builder().merchantId(merchantId).value(value).build();
		
		HttpEntity<FraudRequest> httpEntity = new HttpEntity<>(request);
		
		ResponseEntity<FraudResponse> result = restTemplate.exchange(baseUrl, HttpMethod.POST, httpEntity, FraudResponse.class);
		
		log.info("evaluate fraud response: [{}]", result.getBody());
		
		return result.getBody();
	}
}
