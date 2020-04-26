package com.guedim.activemqsender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.guedim.activemqsender.model.Message;

@Component
public class HttpSender implements ISender {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpSender.class);
	private static final String URL_MESSAGE = "/message/";
	private static final String URL_TYPE = "?type=queue";
			

	@Value("${spring.activemq.admin-broker-url}")
	private String brokerAdminUrl;
	@Value("${queue.name}")
	private String destination;
	@Autowired
	RestTemplate restTemplate;

	public void send(Message message) {
		LOGGER.info("sending http message='{}'", message);

		try {
			String url = brokerAdminUrl + URL_MESSAGE + destination + URL_TYPE;
			HttpEntity<Message> httpEntity = new HttpEntity<>(message);
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
			LOGGER.debug("processed message with response='{}'", result.getBody());

		} catch (Exception ex) {
			LOGGER.error("Error processing record",ex);
		}
	}

	@Override
	public String getType() {
		return "HTTP";
	}
}