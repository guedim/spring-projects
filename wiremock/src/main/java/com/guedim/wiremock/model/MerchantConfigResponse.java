package com.guedim.wiremock.model;

import lombok.Data;

@Data
public class MerchantConfigResponse {

	public Boolean isValidateFraud;
	public Boolean isSendWebHook;
	public String urlNotification;
	
}
