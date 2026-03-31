package com.controlflows;

import java.util.Scanner;

public class FactorialUsingFor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int number = sc.nextInt();
		if (number <= 0) {
			System.out.println("Please enter a positive number");
		} else {
			int factorial = 1;
			for (int i = 1; i <= number; i++) {
				factorial *= i;
			}
			System.out.println("Factorial of entered number: " + factorial);
		}
		sc.close();
	}

}