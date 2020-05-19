package com.guedim.wiremock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;


//@SpringBootTest(properties = "app.baseUrl=http://localhost:${wiremock.server.port}", webEnvironment = WebEnvironment.NONE)
//@AutoConfigureWireMock(port = 0, stubs = "file:src/test/resources/mappings")
public class UserServiceClientIntegrationTest {
	
	private static ObjectMapper mapper = new ObjectMapper();


	//@Configuration
	//@EnableFeignClients(clients = { UserFeignClient.class })
	//@ImportAutoConfiguration({ HttpMessageConvertersAutoConfiguration.class, RibbonAutoConfiguration.class,
	//		FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class })
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

	//@Autowired // this is the FeignClient service interface
	public UserFeignClient client;

	//@Test
	public void testGetUser() throws JsonProcessingException {
		System.out.println(mapper.writeValueAsString(client.getUsers()));
		//List<String> users = client.getUsers();
		//assertTrue(users.size() > 0);
	}

}