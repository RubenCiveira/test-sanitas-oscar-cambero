package com.test.calculator.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.calculator.CalculatorApplication;
import com.test.calculator.service.ServiceCalculator;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorApplication.class)

public class ExceptionTest {

	@Autowired
	ServiceCalculator serviceCalculator;


    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

	@Test
	void testExceptionCalculadora1() {

		Assertions.assertThrows(ExceptionCalculator.class, () -> {
			BigDecimal bd1 = new BigDecimal(1);
			BigDecimal bd2 = new BigDecimal(1);
			serviceCalculator.operation(bd1, bd2, "AD");
		});
	}

	@Test
	void testExceptionCalculadora2() throws ExceptionCalculator {

		Assertions.assertThrows(ExceptionCalculator.class, () -> {
			BigDecimal bd1 = new BigDecimal(1);
			BigDecimal bd2 = new BigDecimal(1);
			serviceCalculator.operation(bd1, bd2, "/");
		});
	}

	
	 @Test
    public void handleGenericNotFoundException() {
		 NumberFormatException e = new NumberFormatException();
        ResponseEntity<Object> result = handler.handleNumberFormatException(e);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
