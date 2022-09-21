package com.prueba.calculadora.service.impl;

import java.math.BigDecimal;

import com.prueba.calculadora.service.MathOperation;

/**
 * Clase resta.
 *
 */
public class Resta implements MathOperation {

	@Override
	public BigDecimal calculate(BigDecimal numero1, BigDecimal numero2) {
		return numero1.subtract(numero2);
	}
	

}
