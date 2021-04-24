package com.business.cybord.config;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.models.error.IsbgServiceException;

@ControllerAdvice
public class ServicesExceptionHandler {

	

	private static final Logger log = LoggerFactory.getLogger(ServicesExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<IsbgServiceException> handleException(Exception ex, WebRequest request) {
		log.error("Unhandled exception", ex);
		return new ResponseEntity<>(new IsbgServiceException(
				String.format("Ooops algo salio mal, si el error persiste hazlonos saber. Detalles: %s", ex.getMessage()),
				ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ResponseStatusException.class)
	protected ResponseEntity<IsbgServiceException> handleResponseStatusException(ResponseStatusException ex,
			WebRequest request) {
		log.error("ResponseStatusException", ex);
		return new ResponseEntity<>(new IsbgServiceException(ex.getReason(), ex.getMessage(), ex.getStatus().value()),
				ex.getStatus());
	}

	@ExceptionHandler(value = IsbgServiceException.class)
	protected ResponseEntity<IsbgServiceException> handleIsbgException(IsbgServiceException ex, WebRequest request) {
		log.error("IsbgServiceException", ex);
		return new ResponseEntity<>(ex, HttpStatus.valueOf(ex.getHttpStatus()));
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
		log.error("ConstraintViolationException : ", ex);
		
		
		return new ResponseEntity<>(new IsbgServiceException("Error en la informacion, datos duplicados o invalidos",
				ex.getMessage(), HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
		
	}

	@ExceptionHandler(value = { DuplicateKeyException.class })
	protected ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex, WebRequest request) {
		log.error("DuplicateKeyException : ", ex);
		return new ResponseEntity<>(new IsbgServiceException("Error en la informacion, datos duplicados",
				ex.getMessage(), HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
	}

}
