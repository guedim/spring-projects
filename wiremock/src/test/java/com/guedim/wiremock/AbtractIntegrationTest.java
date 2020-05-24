package com.guedim.wiremock;

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

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

@ContextConfiguration(initializers = AbtractIntegrationTest.Initializer.class, classes = {
		AbtractIntegrationTest.LocalRibbonClientConfiguration.class })
@SpringBootTest(properties = "app.config-service.base-path=", webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0, stubs = "classpath*:/wiremock/**/mappings/**/*.json", files = "classpath:/wiremock")
public class AbtractIntegrationTest {

	@LocalServerPort
	protected int port;

	@ClassRule
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer().withDatabaseName("demo")
			.withPassword("demopassword").withUsername("demouser");

	@EnableAutoConfiguration
	// @EnableFeignClients(clients = {ConfigurationFeignClient.class})
	// @RibbonClients({@RibbonClient(name = "configurationFeignClient",
	// configuration = LocalRibbonClientConfiguration.class)})
	// @RibbonClient(name = "configurationFeignClient", configuration =
	// LocalRibbonClientConfiguration.class)
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

			// configurableApplicationContext.getEnvironment().getSystemProperties().put("ribbon.eureka.eureka","false");
			// configurableApplicationContext.getEnvironment().getSystemProperties().put("app.config-service.base-path","http://localhost:"+configurableApplicationContext.getEnvironment().getProperty("wiremock.server.port"));
			// configurableApplicationContext.getEnvironment().getSystemProperties().put("configurationFeignClient.ribbon.listOfServers","http://localhost:"+configurableApplicationContext.getEnvironment().getProperty("wiremock.server.port"));

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
