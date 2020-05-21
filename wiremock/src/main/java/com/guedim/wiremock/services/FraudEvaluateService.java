package com.guedim.wiremock.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guedim.wiremock.clients.FraudEvaluationClient;
import com.guedim.wiremock.model.FraudResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FraudEvaluateService {

	@Autowired
	private FraudEvaluationClient client;
	
	public FraudResponse fraudEvaluate(Integer merchantId, BigDecimal value) {	
		log.info("getting fraud evaluation for merchantId {} and value {}", merchantId, value);
		return client.evaluate(merchantId, value);
	}
}
