package com.test.calculator.service;

import java.math.BigDecimal;

/**
 * 
 * Class that performs an operation.
 *
 */
public interface MathOperation {
	
	public BigDecimal calculate (BigDecimal number1, BigDecimal number2);

}
