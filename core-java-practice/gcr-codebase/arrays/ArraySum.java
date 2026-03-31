package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class ArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[] numbers = new double[10];
		double total = 0.0;
		int index = 0;

		while (true) {
			System.out.print("Enter a number (0 or negative to stop): ");
			double input = sc.nextDouble();

			if (input <= 0) {
				break;
			}

			if (index == 10) {
				System.out.println("Maximum of 10 numbers reached.");
				break;
			}

			numbers[index] = input;
			index++;
		}

		for (int i = 0; i < index; i++) {
			total += numbers[i];
		}

		System.out.println("Entered numbers:");
		for (int i = 0; i < index; i++) {
			System.out.print(numbers[i] + " ");
		}

		System.out.println("Total sum = " + total);

		sc.close();
	}
}
