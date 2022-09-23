package com.test.calculator.service;

import java.math.BigDecimal;

import com.test.calculator.exception.ExceptionCalculator;



/**
 * 
 * Class that contains the different functionalities of a calculator.
 *
 */
public interface ServiceCalculator  {
	
	/**
	 * Perform operations with two numbers.
	 * @param number1.
	 * @param number2.
	 * @return Operation result.
	 */
	BigDecimal operation(BigDecimal number1, BigDecimal number2, String operation) throws ExceptionCalculator;
	

}
