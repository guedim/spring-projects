package com.guedim.wiremock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.guedim.wiremock.model.ProcessResponse;
import com.guedim.wiremock.model.ProcessState;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NullPointerException.class,  IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<ProcessResponse> handleConflict(RuntimeException ex, WebRequest request) {
		
		log.error("error processing request, message: {} ", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ProcessResponse.builder().processId(1).state(ProcessState.ERROR).message(ex.getMessage()).build());
	}
}
