package com.guedim.wiremock;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.guedim.wiremock.model.ProcessRequest;
import com.guedim.wiremock.model.ProcessResponse;

public class HttpRequestTest extends AbtractIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void processTest() throws Exception {
		
		String baseUrl = "http://localhost:" + port + "/mocks/process";

		ProcessRequest request =  ProcessRequest.builder().merchantId(1).value(BigDecimal.TEN).build();		
		HttpEntity<ProcessRequest> httpEntity = new HttpEntity<>(request);
		
		ResponseEntity<ProcessResponse> result = restTemplate.exchange(baseUrl, HttpMethod.POST, httpEntity, ProcessResponse.class);
		
		System.out.println(result);
	}
	
	
}
