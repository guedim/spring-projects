package com.guedim.wiremock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guedim.wiremock.clients.ConfigurationFeignClient;
import com.guedim.wiremock.model.MerchantConfigResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConfigurationService {
	
	@Autowired
	private ConfigurationFeignClient client;
	
	public List<MerchantConfigResponse> getMerchantConfigurations(Integer merchantId) {	
		

		log.info("getting configuration for merchantId {}", merchantId);
		return client.getConfigs(merchantId);
	}

}