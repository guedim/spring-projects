package com.guedim.activemqsender.sender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderFactory {

	@Autowired
	private List<ISender> senders;

	private static final Map<String, ISender> mySendersCache = new HashMap<>();

	@PostConstruct
	public void initMyServiceCache() {
		for (ISender sender : senders) {
			mySendersCache.put(sender.getType(), sender);
		}
	}

	public static ISender getSender(String type) {
		ISender sender = mySendersCache.get(type.toUpperCase());
		if (sender == null)
			throw new RuntimeException("Unknown service type: " + type);
		return sender;
	}
}