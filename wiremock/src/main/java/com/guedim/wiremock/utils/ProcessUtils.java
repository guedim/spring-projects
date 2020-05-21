package com.guedim.wiremock.utils;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.guedim.wiremock.model.MerchantConfigResponse;
import com.guedim.wiremock.model.ProcessResponse;
import com.guedim.wiremock.model.ProcessState;

public final class ProcessUtils {

	public static String getUrlNotification(List<MerchantConfigResponse> merchantConfigurations) {
		return merchantConfigurations.stream().filter(c -> c.getKey().equals("urlNotification")).findAny()
				.map(c -> c.getValue()).orElseGet(String::new);
	}

	public static Boolean getWebHookConfiguration(List<MerchantConfigResponse> merchantConfigurations) {

		return getConfiguration("isSendWebHook", merchantConfigurations);
	}

	public static Boolean getFraudConfiguration(List<MerchantConfigResponse> merchantConfigurations) {

		return getConfiguration("isValidateFraud", merchantConfigurations);
	}

	public static ResponseEntity<ProcessResponse> createErrorResponse(String message) {
		return ResponseEntity
				.ok(ProcessResponse.builder().processId(1).state(ProcessState.ERROR).message(message).build());
	}
	
	private static Boolean getConfiguration(String configuration, List<MerchantConfigResponse> merchantConfigurations) {
		return merchantConfigurations.stream().filter(c -> c.getKey().equals(configuration)).findAny()
				.map(c -> c.getValue()).map(v -> Boolean.valueOf(v)).orElseGet(() -> Boolean.FALSE);

	}

}
