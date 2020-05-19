package com.guedim.wiremock.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.guedim.wiremock.model.MerchantConfigResponse;

@FeignClient(name="configurationFeignClient")
public interface ConfigurationFeignClient {
	
	@GetMapping(value = "${app.config-service.base-path:}/configs/{id}")
    List<MerchantConfigResponse> getConfigs(@PathVariable("id") final Integer merchantId);
}