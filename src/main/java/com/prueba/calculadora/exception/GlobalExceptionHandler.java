package com.prueba.calculadora.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador de excepciones.
 * 
 *
 */
@RestControllerAdvice(basePackages = { "com.iteriam.calculadora.controller" })
public class GlobalExceptionHandler {

	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", "Formato incorrecto de número");
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ExceptionCalculadora.class)
	public final ResponseEntity<Object> handleExceptionCalculadora(ExceptionCalculadora ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
