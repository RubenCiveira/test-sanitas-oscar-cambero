package com.test.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.test.calculator.CalculatorApplication;
import com.test.calculator.service.ServiceCalculator;
import com.test.calculator.service.impl.ServiceCalculatorImpl;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { CalculatorApplication.class, ServiceCalculatorImpl.class })
@WebMvcTest
public class CalculatorControllerTest {

	@MockBean
	ServiceCalculator serviceCalculator;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void sumar() throws Exception {
		BigDecimal bd1 = new BigDecimal(2);
		BigDecimal bd2 = new BigDecimal(2);

		Mockito.when(serviceCalculator.operation(bd1, bd2, "add")).thenReturn(new BigDecimal(4));

		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/rest/calculator/operations?numberTwo=2&numberOne=2&operation=add"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String decimal = result.getResponse().getContentAsString();
		assertNotNull(decimal);
		assertEquals("4", decimal);

	}
}