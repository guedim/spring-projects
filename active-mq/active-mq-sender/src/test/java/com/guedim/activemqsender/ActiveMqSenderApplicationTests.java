package com.guedim.activemqsender;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.guedim.activemqsender.model.Message;
import com.guedim.activemqsender.sender.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
class ActiveMqSenderApplicationTests {

	@ClassRule
	public static EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();
	
	@Autowired
	private Sender sender;

	@Test
	void testSender() throws InterruptedException {
		for (int i = 1; i < 1000; i++) {
			Message m = new Message(i, null);
			sender.send(m);
			Thread.sleep(50);
		}

	}

}
