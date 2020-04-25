package com.guedim.activemqsender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.guedim.activemqsender.model.Message;

@Component
public class JmsSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(JmsSender.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(Message message) {
		LOGGER.info("sending message='{}'", message);
		jmsTemplate.convertAndSend(message);
	}

}
