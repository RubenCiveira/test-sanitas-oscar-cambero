package com.prueba.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.prueba.calculadora.CalculadoraApplication;
import com.prueba.calculadora.service.ServiceCalculadora;
import com.prueba.calculadora.service.impl.ImplServiceCalculadora;

@ComponentScan(basePackages = "com.prueba.calculadora")
@AutoConfigureMockMvc
@ContextConfiguration(classes = { CalculadoraApplication.class, ImplServiceCalculadora.class })
@WebMvcTest
public class ControllerTest {

	@MockBean
	ServiceCalculadora serviceCalculadora;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sumar() throws Exception {
		BigDecimal bd1 = new BigDecimal(2);
		BigDecimal bd2 = new BigDecimal(2);

		Mockito.when(serviceCalculadora.operar(bd1, bd2, "+")).thenReturn(new BigDecimal(4));

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/rest/calculadora/operaciones?numeroDos=2&numeroUno=2&operacion=+"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String decimal = result.getResponse().getContentAsString();
		assertNotNull(decimal);
		assertEquals("4", decimal);

	}
}