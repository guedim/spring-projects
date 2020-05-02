package com.guedim.debezium.utils;

public enum Operation {

	READ("r","after"), 
	CREATE("c","after"), 
	UPDATE("u","after"), 
	DELETE("d","delete");

	private final String code;
	private final String record;
	

	private Operation(String code, String record) {
		this.code = code;
		this.record = record;
	}

	public String getCode() {
		return this.code;
	}
	
	public String getRecord() {
		return this.record;
	}

	public static Operation getOperation(String code) {
		for (Operation op : values()) {
			if (op.code.equalsIgnoreCase(code)) {
				return op;
			}
		}
		return null;
	}
}