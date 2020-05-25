package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProcessResponse {

	private Integer processId;
	private ProcessRecodState state;
	private String message;

}
