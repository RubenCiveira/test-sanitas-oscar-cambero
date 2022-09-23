package com.test.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class CalculatorConfig {
	@Bean
	public TracerImpl getTracer() {
		return new TracerImpl();
	}
}
