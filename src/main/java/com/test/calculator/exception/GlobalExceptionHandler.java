package com.test.calculator.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler.
 * 
 *
 */
@RestControllerAdvice(basePackages = { "com.test.calculator.controller" })
public class GlobalExceptionHandler {

	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "Wrong number format");
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ExceptionCalculator.class)
	public final ResponseEntity<Object> handleExceptionCalculadora(ExceptionCalculator ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
