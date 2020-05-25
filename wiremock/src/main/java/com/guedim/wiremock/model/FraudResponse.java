package com.guedim.wiremock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FraudResponse {
	private Integer merchantId;
	private FraudState state;
	private String description;
}