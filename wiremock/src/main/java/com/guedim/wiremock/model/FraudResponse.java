package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FraudResponse {
	public Integer merchantId;
	public FraudState state;
	public String description;
}