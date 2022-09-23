
package com.test.calculator.controller;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.calculator.exception.ExceptionCalculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
public interface RestApi {

	@Operation(summary = "operations of a calculator", description = "calculator operations (addition/subtraction)", tags = {
			"calculadora-controller" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK - Result of the operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BigDecimal.class))),

			@ApiResponse(responseCode = "401", description = "Unauthorized"),

			@ApiResponse(responseCode = "403", description = "Forbidden"),

			@ApiResponse(responseCode = "404", description = "Not Found") })
	@RequestMapping(value = "/rest/calculator/operations", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<BigDecimal> operations(
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "First operand of the operation", required = true, schema = @Schema()) @Valid @RequestParam(value = "numberOne", required = true) BigDecimal numberOne,
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "Second operand of the operationn", required = true, schema = @Schema()) @Valid @RequestParam(value = "numberTwo", required = true) BigDecimal numberTwo,
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "Operation to perform with the operands", required = true, schema = @Schema(allowableValues = {
					"ADD", "SUB", "+",
					"-" })) @Valid @RequestParam(value = "operation", required = true) String operation)
			throws ExceptionCalculator;

}
