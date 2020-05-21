package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FraudResponse {
	private Integer merchantId;
	private FraudState state;
	private String description;
}