package com.guedim.wiremock.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProcessResponse {

	public Integer processId;
	public ProcessState state;
	public String message;

}
