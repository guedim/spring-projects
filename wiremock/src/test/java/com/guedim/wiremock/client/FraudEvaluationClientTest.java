package com.guedim.wiremock.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guedim.wiremock.clients.FraudEvaluationClient;
import com.guedim.wiremock.model.FraudResponse;
import com.guedim.wiremock.model.FraudState;

public class FraudEvaluationClientTest extends AbstractClientConfiguration {

	@Autowired
	private FraudEvaluationClient client;

	@Test
	public void testgo() throws Exception {
		FraudResponse response = client.evaluate(1, BigDecimal.TEN);

		assertThat(response).isNotNull();
		assertThat(response.getState()).isEqualTo(FraudState.APPROVED);
		assertThat(response.getDescription()).isEqualTo("optional data");
	}

}
