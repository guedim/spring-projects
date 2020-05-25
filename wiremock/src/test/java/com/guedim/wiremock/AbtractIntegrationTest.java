package com.guedim.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ContextConfiguration(initializers = AbtractIntegrationTest.Initializer.class, classes = {AbtractIntegrationTest.LocalRibbonClientConfiguration.class })
@SpringBootTest(properties = { "app.config-service.base-path=","app.fraud-service.base-path=http://localhost:${wiremock.server.port}/evaluate"}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0, stubs = "classpath*:/wiremock/**/mappings/**/*.json", files = "classpath:/wiremock")
public class AbtractIntegrationTest {

	@LocalServerPort
	protected int port;

	@ClassRule
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer().withDatabaseName("demo")
			.withPassword("demopassword").withUsername("demouser");
	

	//@ClassRule
	//public static MockServerContainer mockServer = new MockServerContainer("5.10.0");
	
	@ClassRule
	public static WireMockServer wireMockServer = new WireMockServer(1080);


	@EnableAutoConfiguration
	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			postgreSQLContainer.start();
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.url",
					postgreSQLContainer.getJdbcUrl());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.username",
					postgreSQLContainer.getUsername());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.password",
					postgreSQLContainer.getPassword());
			
			
			// Server mock with  MockServerContainer
			/*mockServer.start();
			String host = mockServer.getHost();
			int port = mockServer.getServerPort();
			log.info("Servermock notification server is running on host =  {}  and port = {}",host, port);
			new MockServerClient(host, port)
					.when(request().withPath("/webhook/notification").withMethod("POST"))
					.respond(response().withBody("Everything was just fine!").withStatusCode(200)
							.withReasonPhrase("Notification processed"));*/
			
			// Server mock with wiremock
			wireMockServer.start();
			int port = wireMockServer.port();
			log.info("Wiremock notification server is running on port = {}", port);
			WireMock.configureFor("localhost", port);
			stubFor(post(urlPathEqualTo("/webhook/notification"))
					.willReturn(aResponse().withBody("Everything was just fine!").withStatus(200)
							.withStatusMessage("Notification processed")));

		}
	}

	@TestConfiguration
	public static class LocalRibbonClientConfiguration {
		
		@Autowired
		Environment env;

		@Bean
		public ServerList<Server> ribbonServerList() {
			return new StaticServerList<>(new Server("localhost", Integer.valueOf(this.env.getProperty("wiremock.server.port"))  ));
		}
	}
}
