package com.guedim.wiremock.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProcessRequest {
	
	private Integer merchantId;
	private BigDecimal value;
	private String description;
}
