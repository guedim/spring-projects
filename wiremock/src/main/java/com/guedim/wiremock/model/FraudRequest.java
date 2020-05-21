package com.guedim.wiremock.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudRequest {
	private Integer merchantId;
	private BigDecimal value;
}