package com.guedim.wiremock.clients;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.guedim.wiremock.model.MerchantConfigResponse;

@FeignClient(name = "configurationFeignClient", fallback = ConfigurationFeignClientFallback.class)
public interface ConfigurationFeignClient {

	@GetMapping(value = "${app.config-service.base-path:}/configs/{id}")
	List<MerchantConfigResponse> getConfigs(@PathVariable("id") final Integer merchantId);
}

class ConfigurationFeignClientFallback implements ConfigurationFeignClient {

	@Override
	public List<MerchantConfigResponse> getConfigs(Integer merchantId) {
		return Collections.emptyList();
	}
}