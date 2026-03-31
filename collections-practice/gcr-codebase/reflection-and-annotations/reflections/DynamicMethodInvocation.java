package com.collections.reflections;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

	private int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
}

public class DynamicMethodInvocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter operation (add/subtract/multiply): ");
			String operation = sc.next();

			System.out.print("Enter first number: ");
			int a = sc.nextInt();

			System.out.print("Enter second number: ");
			int b = sc.nextInt();

			MathOperations math = new MathOperations();

			Class<?> cls = math.getClass();

			Method method = cls.getDeclaredMethod(operation, int.class, int.class);
			method.setAccessible(true);

			Object result = method.invoke(math, a, b);
			System.out.println("Result: " + result);

		} catch (NoSuchMethodException e) {
			System.out.println("Invalid operation name!");
		} catch (Exception e) {
			System.err.println("An error occured" + e);
		}
	}
}
