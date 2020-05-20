package com.guedim.wiremock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedim.wiremock.model.MerchantConfigResponse;
import com.guedim.wiremock.model.ProcessRequest;
import com.guedim.wiremock.model.ProcessResponse;
import com.guedim.wiremock.model.ProcessState;
import com.guedim.wiremock.services.ConfigurationService;

import lombok.SneakyThrows;

@RestController
@RequestMapping(value = "process")
public class ProcessController {

	@Autowired
	ConfigurationService configurationService;

	@PostMapping
	@SneakyThrows
	public ProcessResponse create(@RequestBody ProcessRequest request) {

		List<MerchantConfigResponse> merchantConfigurations = configurationService
				.getMerchantConfigurations(request.getMerchantId());

		if (merchantConfigurations.isEmpty()) {
			return createErrorResponse("invalid configuration options");
		}

		Optional<Boolean> rta =  merchantConfigurations.stream()
				.filter(c -> c.key.equals("isValidateFraud"))
				.findAny()
				.map(c -> c.getValue())
				.map(v-> Boolean.valueOf(v));				
				
		return ProcessResponse.builder().processId(1).state(ProcessState.OK).build();
	}

	private ProcessResponse createErrorResponse(String message) {
		return ProcessResponse.builder().processId(1).state(ProcessState.ERROR).message(message).build();
	}

}