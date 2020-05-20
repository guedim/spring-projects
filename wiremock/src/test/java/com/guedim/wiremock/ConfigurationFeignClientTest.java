package com.guedim.wiremock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
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

import com.guedim.wiremock.clients.ConfigurationFeignClient;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;



@SpringBootTest(properties = "app.config-service.base-path=", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0,stubs = "classpath*:/wiremock/**/mappings/**/*.json",  files = "classpath:/wiremock")
public class ConfigurationFeignClientTest {

	
	@Configuration
	@EnableFeignClients(clients = {ConfigurationFeignClient.class})
	@ImportAutoConfiguration({
			HttpMessageConvertersAutoConfiguration.class,
			RibbonAutoConfiguration.class,
			FeignRibbonClientAutoConfiguration.class,
			FeignAutoConfiguration.class})
	static class ContextConfiguration {

		@Autowired
		Environment env;

		@Bean
		ServletWebServerFactory servletWebServerFactory(){
			return new TomcatServletWebServerFactory();
		}

		@Bean
		public ServerList<Server> ribbonServerList() {
			return new StaticServerList<>(new Server("localhost", Integer.valueOf(this.env.getProperty("wiremock.server.port"))));
		}
	}
	
    @Autowired
    public ConfigurationFeignClient client;
    

    @Test
    public void createSome() {
    	client.getConfigs(1);
    }
}