 package com.guedim.wiremock.context;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(initializers = AbtractIntegrationTestIT.Initializer.class, classes = {AbtractIntegrationTestIT.LocalRibbonClientConfiguration.class })
@SpringBootTest(properties = { "app.config-service.base-path=","app.fraud-service.base-path=http://localhost:${wiremock.server.port}/evaluate"}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0, stubs = "classpath*:/wiremock/**/mappings/**/*.json", files = "classpath:/wiremock")
@Testcontainers
public abstract class AbtractIntegrationTestIT {

	@LocalServerPort
	protected int port;

	@Container
	private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>().withDatabaseName("demo")
			.withPassword("demopassword").withUsername("demouser")
			.waitingFor(new HostPortWaitStrategy());

	private static WireMockServer wireMockServer = new WireMockServer(1080);

	@BeforeAll
	private static void wiremockNotificationServerSetUp() {
		wireMockServer.start();
		int port = wireMockServer.port();
		log.info("Wiremock notification server is running on port = {}", port);
		WireMock.configureFor("localhost", port);
		stubFor(post(urlPathEqualTo("/webhook/notification")).willReturn(aResponse()
				.withBody("Everything was just fine!").withStatus(200).withStatusMessage("Notification processed")));

	}

	@EnableAutoConfiguration
	protected static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
							"spring.datasource.username=" + postgreSQLContainer.getUsername(),
							"spring.datasource.password=" + postgreSQLContainer.getPassword())
					.applyTo(configurableApplicationContext);

		}
	}

	@TestConfiguration
	protected static class LocalRibbonClientConfiguration {

		@Autowired
		Environment env;

		@Bean
		public ServerList<Server> ribbonServerList() {
			return new StaticServerList<>(
					new Server("localhost", Integer.valueOf(this.env.getProperty("wiremock.server.port"))));
		}
	}
}
