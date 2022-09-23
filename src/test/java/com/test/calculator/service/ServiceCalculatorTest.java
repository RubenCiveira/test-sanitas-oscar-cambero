package com.test.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.calculator.CalculatorApplication;
import com.test.calculator.exception.ExceptionCalculator;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorApplication.class)

public class ServiceCalculatorTest {

	@Autowired
	ServiceCalculator serviceCalculator;


	@DisplayName("Test add ok with operation = +")
	@Test
	void add1() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculator.operation(bd1, bd2, "+"));
	}

	@DisplayName("Test add ok with operation = add")
	@Test
	void add2() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculator.operation(bd1, bd2, "add"));
	}

	@DisplayName("Test add ok with operation = ADD")
	@Test
	void add3() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculator.operation(bd1, bd2, "ADD"));
	}

	@DisplayName("Test sub ok with operation = -")
	@Test
	void sub1() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculator.operation(bd1, bd2, "-"));
	}

	@DisplayName("Test sub ok with operation = sub")
	@Test
	void sub2() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculator.operation(bd1, bd2, "sub"));
	}

	@DisplayName("Test sub ok with operation = SUB")
	@Test
	void sub3() throws ExceptionCalculator {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculator.operation(bd1, bd2, "SUB"));
	}



}
