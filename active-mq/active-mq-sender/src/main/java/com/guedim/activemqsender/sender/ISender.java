package com.guedim.activemqsender.sender;

import com.guedim.activemqsender.model.Message;

public interface ISender {

	String getType();
	
	void send(Message message);
}
