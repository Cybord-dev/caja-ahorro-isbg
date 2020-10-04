package com.business.cybord.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.models.error.IsbgServiceException;

@ControllerAdvice
public class ServicesExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<IsbgServiceException> handleException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(
				new IsbgServiceException(ex.getMessage(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ResponseStatusException.class)
	protected ResponseEntity<IsbgServiceException> handleResponseStatusException(ResponseStatusException ex,
			WebRequest request) {
		return new ResponseEntity<>(
				new IsbgServiceException(ex.getReason(),ex.getMessage(), ex.getStatus().value()),
				ex.getStatus());
	}

	@ExceptionHandler(value = IsbgServiceException.class)
	protected ResponseEntity<IsbgServiceException> handleIsbgException(IsbgServiceException ex, WebRequest request) {
		return new ResponseEntity<>(ex, HttpStatus.valueOf(ex.getHttpStatus()));
	}

}
