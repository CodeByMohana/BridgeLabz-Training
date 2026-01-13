package com.collections.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticExceptionTest {
	ArithmeticExceptions exp = new ArithmeticExceptions();
	@Test
	 void testDivideByZero() {
        assertThrows(ArithmeticException.class,
            () -> exp.divide(10, 0));
    }

}
