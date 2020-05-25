package com.guedim.wiremock.controller;

import static com.guedim.wiremock.utils.ProcessUtils.createErrorResponse;
import static com.guedim.wiremock.utils.ProcessUtils.getFraudConfiguration;
import static com.guedim.wiremock.utils.ProcessUtils.getUrlNotification;
import static com.guedim.wiremock.utils.ProcessUtils.getWebHookConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedim.wiremock.model.FraudResponse;
import com.guedim.wiremock.model.FraudState;
import com.guedim.wiremock.model.MerchantConfigResponse;
import com.guedim.wiremock.model.ProcessRecodState;
import com.guedim.wiremock.model.ProcessRecord;
import com.guedim.wiremock.model.ProcessRequest;
import com.guedim.wiremock.model.ProcessResponse;
import com.guedim.wiremock.repository.ProcessRecordRepository;
import com.guedim.wiremock.services.ConfigurationService;
import com.guedim.wiremock.services.FraudEvaluateService;
import com.guedim.wiremock.services.WebHookService;

@RestController
@RequestMapping(value = "process")
public class ProcessController {

	@Autowired
	ConfigurationService configurationService;

	@Autowired
	FraudEvaluateService fraudService;

	@Autowired
	WebHookService webHookService;
	
	@Autowired
	private ProcessRecordRepository repository;
	
	
	@GetMapping
	public ResponseEntity<HttpStatus> ping() {
		return ResponseEntity.ok(HttpStatus.OK);
	}
 
	

	@PostMapping
	public ResponseEntity<ProcessResponse> process(@RequestBody ProcessRequest request) {

		Integer merchantId = request.getMerchantId();
		BigDecimal value = request.getValue();
		Long processRecordId = null;
		FraudResponse fraudResponse = null;

		ProcessRecord processRecord = ProcessRecord.builder().merchantId(merchantId).value(value)
				.creationDate(LocalDateTime.now()).processRecordState(ProcessRecodState.NEW).build();
		processRecordId = repository.save(processRecord).getId();
		

		List<MerchantConfigResponse> merchantConfigurations = configurationService
				.getMerchantConfigurations(merchantId);

		if (merchantConfigurations.isEmpty()) {
			repository.updateErrorState(processRecordId);
			return createErrorResponse("merchat without configuration options");
		}

		Boolean evaluateFraud = getFraudConfiguration(merchantConfigurations);
		if (evaluateFraud) {
			fraudResponse = fraudService.fraudEvaluate(merchantId, value);
			repository.updateEvaluated(fraudResponse.getState(), fraudResponse.getDescription(), processRecordId);
		}

		Boolean notifyWebHook = getWebHookConfiguration(merchantConfigurations);
		if (notifyWebHook) {
			String url = getUrlNotification(merchantConfigurations);
			FraudState fraudState = fraudResponse != null ? fraudResponse.getState() : FraudState.REJECTED;
			Integer httpResponseCode = webHookService.sendWebHook(merchantId, url, fraudState);
			repository.updateNotified(url, httpResponseCode, processRecordId);
		}

		return ResponseEntity.ok(ProcessResponse.builder().processId(1).state(ProcessRecodState.NOTIFIED).build());
	}
}