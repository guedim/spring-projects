package com.guedim.wiremock.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.guedim.wiremock.clients.ConfigurationFeignClient;
import com.guedim.wiremock.clients.FraudEvaluationClient;
import com.guedim.wiremock.clients.WebHookClient;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

@ContextConfiguration(classes = { AbstractClientConfiguration.ContextConfiguration.class })
@SpringBootTest(
		properties = { "app.config-service.base-path=","app.fraud-service.base-path=http://localhost:${wiremock.server.port}/evaluate" }, 
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, 
		classes = {FraudEvaluationClient.class, WebHookClient.class, RestTemplate.class })
@AutoConfigureWireMock(port = 0, stubs = "classpath*:/wiremock/**/mappings/**/*.json", files = "classpath:/wiremock")
public class AbstractClientConfiguration {

	@TestConfiguration
	@EnableFeignClients(clients = { ConfigurationFeignClient.class })
	@ImportAutoConfiguration({ HttpMessageConvertersAutoConfiguration.class, RibbonAutoConfiguration.class,
			FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class })
	protected static class ContextConfiguration {

		@Autowired
		Environment env;

		@Bean
		ServletWebServerFactory servletWebServerFactory() {
			return new TomcatServletWebServerFactory();
		}

		@Bean
		public ServerList<Server> ribbonServerList() {
			return new StaticServerList<>(
					new Server("localhost", Integer.valueOf(this.env.getProperty("wiremock.server.port"))));
		}

		@Bean
		public RestTemplateBuilder restTemplateBuilder() {

			return new RestTemplateBuilder();
		}
	}
}
