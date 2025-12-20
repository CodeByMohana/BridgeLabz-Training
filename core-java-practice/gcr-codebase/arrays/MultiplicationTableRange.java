package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class MultiplicationTableRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number to find its multiplication table from 6 to 9: ");
		int number = sc.nextInt();

		if (number <= 0) {
			System.out.println("Please enter a natural number (positive integer).");
			return;
		}

		int[] multiplicationResult = new int[4];

		for (int i = 0; i < 4; i++) {
			int multiplier = 6 + i;
			multiplicationResult[i] = number * multiplier;
		}

		for (int i = 0; i < 4; i++) {
			int multiplier = 6 + i;
			System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
		}

		sc.close();
	}
}
