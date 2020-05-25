package com.guedim.wiremock.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.guedim.wiremock.clients.WebHookClient;
import com.guedim.wiremock.model.FraudState;

public class WebHookClientTest extends AbstractClientConfiguration {
	
	
	private String url = null;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WebHookClient client;
	
	@BeforeEach
	public  void setup() {
		url = "http://localhost:" + env.getProperty("wiremock.server.port") + "/notify";
	}
	
	@Test
	public void test() {
		Integer result =  client.sendWebHook(1, url, FraudState.APPROVED);
		
 		assertThat(result).isNotNull();
 		assertThat(result).isEqualTo(200);
	}

}
