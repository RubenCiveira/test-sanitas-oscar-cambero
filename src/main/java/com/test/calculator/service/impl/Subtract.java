package com.test.calculator.service.impl;

import java.math.BigDecimal;

import com.test.calculator.service.MathOperation;

/**
 * Subtract class.
 *
 */
public class Subtract  implements MathOperation {

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		return number1.subtract(number2);
	}
	

}
