package com.prueba.calculadora.controller.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.controller.RestApi;
import com.prueba.calculadora.exception.ExceptionCalculadora;
import com.prueba.calculadora.service.ServiceCalculadora;

import io.corp.calculator.TracerImpl;

/**
 * Controlador que expone los distintos endpoint.
 */
@RestController
@RequestMapping("/rest/calculadora")
public class CalculadoraController implements RestApi {


	private TracerImpl tracer;

	@Autowired
	private final ServiceCalculadora serviceCalculadora;

	public CalculadoraController(ServiceCalculadora serviceCalculadora) {
		this.serviceCalculadora = serviceCalculadora;
	}

	@Autowired
	public void setTracer(TracerImpl tracer) {
		this.tracer = tracer;
	}

	/**
	 * Endpoint /operaciones método GET.
	 * 
	 * @param numeroUno.
	 * @param numeroDos.
	 * @param operacion.	 
	 * @return ResponseEntity<Double> resultado de la operación.
	 * @throws ExceptionCalculadora
	 */
	@GetMapping(value = "/operaciones")
	public ResponseEntity<BigDecimal> operacion(
			@RequestParam(value = "numeroUno", required = true)  BigDecimal numeroUno,
			@RequestParam(value = "numeroDos", required = true) BigDecimal numeroDos,
			@RequestParam(value = "operacion", required = true)  String operacion)
			throws ExceptionCalculadora {

		tracer.trace(String.format("INI GET >>> /operaciones | RequestParam numeroUno %s, numeroDos %s, operacion %s",
				numeroUno, numeroDos, operacion));
		BigDecimal resultado = serviceCalculadora.operar(numeroUno, numeroDos, operacion);
		tracer.trace(String.format("FIN GET >>> /operaciones |  resultado %1$,.2f", resultado));

		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}

}