package com.guedim.wiremock;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.guedim.wiremock.clients.FraudEvaluationClient;



@SpringBootTest(classes = WiremockApplication.class, properties = "app.fraud-service.base-path=http://localhost:${wiremock.server.port}/evaluate", webEnvironment = WebEnvironment.NONE)
@AutoConfigureWireMock(port = 0,stubs = "classpath*:/wiremock/**/mappings/**/*.json",  files = "classpath:/wiremock")                                               
public class FraudEvaluationClientTest {

	@Autowired
	private FraudEvaluationClient client;

	@Test
	public void testgo() throws Exception {
		 client.evaluate(1,BigDecimal.TEN);
	}

}
