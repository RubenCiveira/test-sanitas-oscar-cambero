package com.prueba.calculadora.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.calculadora.exception.ExceptionCalculadora;
import com.prueba.calculadora.service.MathOperation;
import com.prueba.calculadora.service.ServiceCalculadora;
import com.prueba.calculadora.utils.Operacion;

import io.corp.calculator.TracerImpl;

@Service
public class ImplServiceCalculadora implements ServiceCalculadora {

	private TracerImpl tracer;
	
	@Autowired
	public void setTracer(TracerImpl tracer) {
		this.tracer = tracer;
	}

	@Override
	public BigDecimal operar(BigDecimal numeroUno, BigDecimal numeroDos, String strOperacion) throws ExceptionCalculadora {

		BigDecimal resultado = null;
		MathOperation mathOperation;

		Operacion operacion = Operacion.obtenerValor(strOperacion);

		switch (operacion) {
		case SUMA:
			mathOperation = new Suma();
			resultado = mathOperation.calculate(numeroUno, numeroDos);
			break;
		case RESTA:
			mathOperation = new Resta();
			resultado = mathOperation.calculate(numeroUno, numeroDos);
			break;
		default:
			tracer.trace(String.format("Operación no soportada para ser calculada %s", strOperacion));
			throw new ExceptionCalculadora	("Operación no soportada para el valor: " + strOperacion);
			

		}

		return resultado;
	}

}
