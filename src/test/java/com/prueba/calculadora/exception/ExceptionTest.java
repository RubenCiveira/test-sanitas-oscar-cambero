package com.prueba.calculadora.exception;

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

import com.prueba.calculadora.CalculadoraApplication;
import com.prueba.calculadora.service.ServiceCalculadora;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculadoraApplication.class)

public class ExceptionTest {

	@Autowired
	ServiceCalculadora serviceCalculadora;


    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

	@Test
	void testExceptionCalculadora1() {

		Assertions.assertThrows(ExceptionCalculadora.class, () -> {
			BigDecimal bd1 = new BigDecimal(1);
			BigDecimal bd2 = new BigDecimal(1);
			serviceCalculadora.operar(bd1, bd2, "SUM");
		});
	}

	@Test
	void testExceptionCalculadora2() throws ExceptionCalculadora {

		Assertions.assertThrows(ExceptionCalculadora.class, () -> {
			BigDecimal bd1 = new BigDecimal(1);
			BigDecimal bd2 = new BigDecimal(1);
			serviceCalculadora.operar(bd1, bd2, "/");
		});
	}

	
	 @Test
    public void handleGenericNotFoundException() {
		 NumberFormatException e = new NumberFormatException();
        ResponseEntity<Object> result = handler.handleNumberFormatException(e);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
