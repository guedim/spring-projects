package com.guedim.wiremock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guedim.wiremock.clients.ConfigurationFeignClient;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;


//@SpringBootTest(properties = "app.config-service.base-path=http://localhost:${wiremock.server.port}", webEnvironment = WebEnvironment.NONE)
//@AutoConfigureWireMock(port = 0, stubs = "file:src/test/resources/mappings")
public class ConfigurationFeignClientTest {
	
	private static ObjectMapper mapper = new ObjectMapper();


	//@Configuration
	//@EnableFeignClients(clients = { ConfigurationFeignClient.class })
	//@ImportAutoConfiguration({ HttpMessageConvertersAutoConfiguration.class, RibbonAutoConfiguration.class,	FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class })
	static class ContextConfiguration {

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
	}

	@Autowired
	public ConfigurationFeignClient client;

	//@Test
	public void testGetUser() throws JsonProcessingException {
		System.out.println(mapper.writeValueAsString(client.getConfigs(1) ));
		//List<String> users = client.getUsers();
		//assertTrue(users.size() > 0);
	}

}