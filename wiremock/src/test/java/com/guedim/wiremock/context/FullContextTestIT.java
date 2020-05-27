package com.guedim.wiremock.context;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.guedim.wiremock.model.ProcessRecodState;
import com.guedim.wiremock.model.ProcessRequest;
import com.guedim.wiremock.model.ProcessResponse;

public class FullContextTestIT extends AbtractIntegrationTestIT {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void fullProcessTest() throws Exception {
		
		// given
		String baseUrl = "http://localhost:" + port + "/mocks/process";
		ProcessRequest request =  ProcessRequest.builder().merchantId(1).value(BigDecimal.TEN).build();		
		HttpEntity<ProcessRequest> httpEntity = new HttpEntity<>(request);
		
		// when 
		ResponseEntity<ProcessResponse> result = restTemplate.exchange(baseUrl, HttpMethod.POST, httpEntity, ProcessResponse.class);
		ProcessResponse response = result.getBody();
		
		// then
		Assert.state(result.getStatusCode().equals(HttpStatus.OK),"http response code must be 200");
		Assert.notNull(response.getProcessId(), "processId must not be null");
		Assert.state(response.getState().equals(ProcessRecodState.NOTIFIED),"process state must be NOTIFIED");
	}
	
	
}
