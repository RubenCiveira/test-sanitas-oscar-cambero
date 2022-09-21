package com.prueba.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;
@Configuration
public class CalculadoraConfig {
	 @Bean
	   public TracerImpl getTracer() {
	      return new TracerImpl();
	   }
}
