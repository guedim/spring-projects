package com.guedim.activemqsender.model;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	private String transactionId;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Integer orderId, String transactionId) {
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Object [orderId=" + orderId + ", transactionId=" + transactionId + "]";
	}

}
