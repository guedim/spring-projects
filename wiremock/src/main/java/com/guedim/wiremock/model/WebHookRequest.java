package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebHookRequest {
	
	private Integer merchantId;
	private FraudState state;
}