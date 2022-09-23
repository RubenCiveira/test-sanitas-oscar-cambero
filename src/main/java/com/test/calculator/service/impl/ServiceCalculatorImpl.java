package com.test.calculator.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.calculator.exception.ExceptionCalculator;
import com.test.calculator.service.MathOperation;
import com.test.calculator.service.Operation;
import com.test.calculator.service.ServiceCalculator;

import io.corp.calculator.TracerImpl;

@Service
public class ServiceCalculatorImpl implements ServiceCalculator {

	private TracerImpl tracer;

	@Autowired
	public void setTracer(TracerImpl tracer) {
		this.tracer = tracer;
	}

	@Override
	public BigDecimal operation(BigDecimal number1, BigDecimal number2, String operation) throws ExceptionCalculator {
		BigDecimal result = null;
		MathOperation mathOperation;

		Operation operacion = Operation.getValue(operation);

		switch (operacion) {
		case ADD:
			mathOperation = new Add();
			result = mathOperation.calculate(number1, number2);
			break;
		case SUB:
			mathOperation = new Subtract();
			result = mathOperation.calculate(number1, number2);
			break;
		default:
			tracer.trace(String.format("Unsupported operation to be calculated %s", operation));
			throw new ExceptionCalculator("Unsupported operation to be calculated: " + operation);

		}

		return result;
	}
}
