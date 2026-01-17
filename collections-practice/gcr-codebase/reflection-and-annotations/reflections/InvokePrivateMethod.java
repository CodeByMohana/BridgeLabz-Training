package com.collections.reflections;

import java.lang.reflect.Method;

class Claculator {

	public int add(int a, int b) {
		return a + b;
	}

	private int multiply(int a, int b) {
		return a * b;
	}
}

public class InvokePrivateMethod {
	public static void main(String[] args) {
		try {
			Claculator cal = new Claculator();

			Class<?> cls = cal.getClass();
			int a = 10;
			int b = 20;

			// Get specific private method directly
			Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

			// Break access control
			method.setAccessible(true);

			// Invoke and CAPTURE return value
			Object result = method.invoke(cal, a, b);

			System.out.println("Result (via Reflection): " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
