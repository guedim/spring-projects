package com.guedim.wiremock.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProcessRequest {
	public Integer merchantId;
	public BigDecimal value;
	public String description;
}
