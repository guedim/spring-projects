package com.guedim.wiremock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

//@SpringBootTest(classes = WiremockTestsApplication.class, properties = "app.baseUrl=http://localhost:${wiremock.server.port}", webEnvironment = WebEnvironment.NONE)
//@AutoConfigureWireMock(port = 0, stubs = "file:src/test/resources/mappings")
public class AutoConfigureWireMockStubsApplicationWithSlashTests {

	//@Autowired
	private Service service;

	//@Test
	public void testgo() throws Exception {
		assertThat(this.service.go()).isEqualTo("Hello World");
	}

}