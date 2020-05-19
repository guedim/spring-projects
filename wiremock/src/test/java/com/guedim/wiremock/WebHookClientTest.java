package com.guedim.wiremock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.env.Environment;

import com.guedim.wiremock.clients.WebHookClient;
import com.guedim.wiremock.model.FraudState;

@SpringBootTest(classes = WiremockApplication.class, webEnvironment = WebEnvironment.NONE)
@AutoConfigureWireMock(port = 0,stubs = "classpath*:/wiremock/**/mappings/**/*.json",  files = "classpath:/wiremock")                                               
public class WebHookClientTest {
	
	
	public String url = null;
	
	@Autowired
	Environment env;
	
	@Autowired
	WebHookClient client;
	
	@BeforeEach
	public  void setup() {
		url = "http://localhost:" + env.getProperty("wiremock.server.port") + "/notify";
	}
	
	@Test
	public void test() {
		client.sendWebHook(1, url, FraudState.APPROVED);
	}

}
