package com.test.calculator.service;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.calculator.exception.ExceptionCalculator;

/**
 * 
 * Enum to obtain the value of the operation.
 *
 */

public enum Operation {

	ADD("+"), SUB("-");

	private static final List<Operation> valores = Arrays.asList(ADD, SUB);
	private String sign;

	Operation(String sign) {
		this.sign = sign;
	}

	private String getSign() {
		return this.sign;
	}

	/**
	 * Parses the string parameter value into an object of type Operation. The value
	 * of String can be both the name ("add", "sub" indifferent case of lowercase)
	 * of the operation as well as the sign ('+', '-')
	 * 
	 * @param value
	 * @return
	 * @throws ExceptionCalculator
	 */
	@JsonCreator
	public static Operation getValue(String value) throws ExceptionCalculator {

		return valores.stream().filter(v -> value.equalsIgnoreCase(v.name()) || value.equalsIgnoreCase(v.getSign()))
				.findAny().orElseThrow(() -> new ExceptionCalculator("Unsupported operation for value: " + value));

	}

}
