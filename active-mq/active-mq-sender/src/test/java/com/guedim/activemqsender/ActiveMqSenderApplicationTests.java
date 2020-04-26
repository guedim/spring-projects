package com.guedim.activemqsender;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.guedim.activemqsender.model.Message;
import com.guedim.activemqsender.sender.HttpSender;
import com.guedim.activemqsender.sender.JmsSender;
import com.guedim.activemqsender.sender.SenderFactory;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "command.line.runner.enabled=false","application.runner.enabled=false"})
@DirtiesContext
class ActiveMqSenderApplicationTests {

	@ClassRule
	public static EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();
	
	@Autowired
	private JmsSender jmsSender;
	
	@Autowired
	private HttpSender httpSender;

	@Test
	void testJmsSender() {
		for (int i = 1; i < 100; i++) {
			Message m = new Message(null, i);
			jmsSender.send(m);
		}
	}
	
	@Test
	void testHttpSender() {
		for (int i = 1; i < 3; i++) {
			Message m = new Message(null, i);
			httpSender.send(m);
		}
	}
	
	@Test
	void testfactory() {
		JmsSender jms1 =  (JmsSender) SenderFactory.getSender("jms");
		JmsSender jms2 =  (JmsSender) SenderFactory.getSender("JMS");
		HttpSender http1 =  (HttpSender) SenderFactory.getSender("http");
		HttpSender http2 =  (HttpSender) SenderFactory.getSender("HTTP");
	}
	
	@Test()
	void testfactoryException() {
		Assertions.assertThrows(RuntimeException.class, () -> {SenderFactory.getSender("not valid");});
	}
}