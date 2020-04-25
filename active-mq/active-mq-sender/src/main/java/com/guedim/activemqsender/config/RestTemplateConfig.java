package com.guedim.activemqsender.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Value("${spring.activemq.user}")
	private String brokerUser;
	@Value("${spring.activemq.password}")
	private String brokerPassword;
	

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		// create a list the headers 
	    	List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
	    interceptors.add(new HttpHeaderInterceptor(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE));
	    interceptors.add(new HttpHeaderInterceptor(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
		
		return builder
				.setConnectTimeout(Duration.ofSeconds(3))
				.setReadTimeout(Duration.ofSeconds(1000))
				.additionalMessageConverters(new MappingJackson2HttpMessageConverter())
				.basicAuthentication(brokerUser, brokerPassword)
				.additionalInterceptors(interceptors)
				.build();
	}
}
