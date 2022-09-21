
package com.prueba.calculadora.controller;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prueba.calculadora.exception.ExceptionCalculadora;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-21T13:55:57.600Z[GMT]")
@Validated
public interface RestApi {

    @Operation(summary = "operaciones de una calculadora", description = "operaciones de una calculadora (suma/resta)", tags={ "calculadora-controller" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK - Resultado de la operación.", content = @Content(mediaType = "*/*", schema = @Schema(implementation = BigDecimal.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        
        @ApiResponse(responseCode = "404", description = "Not Found") })
    @RequestMapping(value = "/rest/calculadora/operaciones",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<BigDecimal> operacion(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Primer operando de la operación" ,example = "100", required=true,schema=@Schema()) @Valid @RequestParam(value = "numeroUno", required = true) BigDecimal numeroUno, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Segundo operando de la operación" ,example = "100",required=true,schema=@Schema()) @Valid @RequestParam(value = "numeroDos", required = true) BigDecimal numeroDos, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Operación a realizar con los operandos" ,example = "SUMA,RESTA,+,-", required=true,schema=@Schema()) @Valid @RequestParam(value = "operacion", required = true) String operacion) throws ExceptionCalculadora;

}

