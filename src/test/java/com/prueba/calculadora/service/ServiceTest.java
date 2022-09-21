package com.prueba.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.prueba.calculadora.CalculadoraApplication;
import com.prueba.calculadora.exception.ExceptionCalculadora;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculadoraApplication.class)

public class ServiceTest {

	@Autowired
	ServiceCalculadora serviceCalculadora;

	@DisplayName("Prueba suma ok con operacion = +")
	@Test
	void suma1() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculadora.operar(bd1, bd2, "+"));
	}

	@DisplayName("Prueba suma ok con operacion = suma")
	@Test
	void suma2() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculadora.operar(bd1, bd2, "suma"));
	}

	@DisplayName("Prueba suma ok con operacion = SUMA")
	@Test
	void suma3() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(2), serviceCalculadora.operar(bd1, bd2, "SUMA"));
	}

	@DisplayName("Prueba resta ok con operacion = -")
	@Test
	void resta1() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculadora.operar(bd1, bd2, "-"));
	}

	@DisplayName("Prueba resta ok con operacion = resta")
	@Test
	void resta2() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculadora.operar(bd1, bd2, "resta"));
	}

	@DisplayName("Prueba resta ok con operacion = RESTA")
	@Test
	void resta3() throws ExceptionCalculadora {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal bd2 = new BigDecimal(1);
		assertEquals(new BigDecimal(0), serviceCalculadora.operar(bd1, bd2, "RESTA"));
	}



}
