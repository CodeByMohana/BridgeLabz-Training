package com.corejavapractice.gcrcodebase.builtinfunctions;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Basic Calculator:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.print("Choose an operation (1-4): ");
		int choice = scanner.nextInt();

		System.out.print("Enter first number: ");
		double a = scanner.nextDouble();
		System.out.print("Enter second number: ");
		double b = scanner.nextDouble();

		double result = 0;
		boolean valid = true;

		switch (choice) {
		case 1:
			result = add(a, b);
			break;
		case 2:
			result = subtract(a, b);
			break;
		case 3:
			result = multiply(a, b);
			break;
		case 4:
			if (b != 0) {
				result = divide(a, b);
			} else {
				System.out.println("Error: Cannot divide by zero.");
				valid = false;
			}
			break;
		default:
			System.out.println("Invalid choice.");
			valid = false;
		}

		if (valid) {
			System.out.println("Result: " + result);
		}

		scanner.close();
	}

	public static double add(double x, double y) {
		return x + y;
	}

	public static double subtract(double x, double y) {
		return x - y;
	}

	public static double multiply(double x, double y) {
		return x * y;
	}

	public static double divide(double x, double y) {
		return x / y;
	}
}