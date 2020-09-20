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
	protected ResponseEntity<ResponseStatusException> handleException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ResponseStatusException.class)
	protected ResponseEntity<ResponseStatusException> handleResponseStatusException(ResponseStatusException ex,
			WebRequest request) {
		return new ResponseEntity<>(ex, ex.getStatus());
	}

	@ExceptionHandler(value = IsbgServiceException.class)
	protected ResponseEntity<ResponseStatusException> handleIsbgException(IsbgServiceException ex,
			WebRequest request) {
		return new ResponseEntity<>(new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex),
				HttpStatus.CONFLICT);
	}

}
