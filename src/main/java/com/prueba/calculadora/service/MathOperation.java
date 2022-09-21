package com.prueba.calculadora.service;

import java.math.BigDecimal;

/**
 * 
 *Clase que realiza una operación.
 *
 */
public interface MathOperation {
	
	public BigDecimal calculate (BigDecimal numero1, BigDecimal numero2);

}
