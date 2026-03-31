package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class OddEvenArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a natural number: ");
		int number = sc.nextInt();

		if (number <= 0) {
			System.out.println("Invalid input! Please enter a natural number (positive integer).");
			return;
		}

		int size = number / 2 + 1;
		int[] evenNumbers = new int[size];
		int[] oddNumbers = new int[size];

		int evenIndex = 0;
		int oddIndex = 0;

		for (int i = 1; i <= number; i++) {
			if (i % 2 == 0) {
				evenNumbers[evenIndex] = i;
				evenIndex++;
			} else {
				oddNumbers[oddIndex] = i;
				oddIndex++;
			}
		}

		System.out.print("Even numbers: ");
		for (int i = 0; i < evenIndex; i++) {
			System.out.print(evenNumbers[i] + " ");
		}
		System.out.println("");

		System.out.print("Odd numbers: ");
		for (int i = 0; i < oddIndex; i++) {
			System.out.print(oddNumbers[i] + " ");
		}

		sc.close();
	}
}
