package com.test.calculator.controller.impl;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.calculator.controller.RestApi;
import com.test.calculator.exception.ExceptionCalculator;
import com.test.calculator.service.ServiceCalculator;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Controller that exposes the different endpoints.
 * 
 */
@RestController

public class CalculatorController implements RestApi {


	private TracerImpl tracer;

	@Autowired
	private final ServiceCalculator serviceCalculator;

	public CalculatorController(ServiceCalculator serviceCalculator) {
		this.serviceCalculator = serviceCalculator;
	}

	@Autowired
	public void setTracer(TracerImpl tracer) {
		this.tracer = tracer;
	}



	@Override
	 public ResponseEntity<BigDecimal> operations(@NotNull @Parameter(in = ParameterIn.QUERY, description = "First operand of the operation" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "numberOne", required = true) BigDecimal numberOne,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Second operand of the operationn" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "numberTwo", required = true) BigDecimal numberTwo,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Operation to perform with the operands" ,required=true,schema=@Schema(allowableValues={ "ADD", "SUB", "+", "-" }
			 )) @Valid @RequestParam(value = "operation", required = true) String operation) throws ExceptionCalculator {
		
		String operationEncoder = URLEncoder.encode(operation, StandardCharsets.UTF_8);
		BigDecimal resultado = serviceCalculator.operation(numberOne, numberTwo, operationEncoder);
		tracer.trace(String.format("END GET >>> /operations |  result %1$,.2f", resultado));
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}




}