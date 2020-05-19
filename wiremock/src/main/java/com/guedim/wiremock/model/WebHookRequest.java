package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebHookRequest {
	public Integer merchantId;
	public FraudState state;
}