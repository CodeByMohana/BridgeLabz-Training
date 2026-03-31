package com.controlflows;

import java.util.Scanner;

public class FactorialUsingWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int factorial = 1;
		while (number != 1) {
			factorial *= number;
			number--;
		}
		System.out.println("Factorial of a entered number: " + factorial);
		sc.close();
	}
}
