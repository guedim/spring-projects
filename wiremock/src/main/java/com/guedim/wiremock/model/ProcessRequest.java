package com.guedim.wiremock.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProcessRequest {
	
	private Integer merchantId;
	private BigDecimal value;
}
