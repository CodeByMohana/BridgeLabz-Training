package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class LargestSecondLargestDynamic {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();

		if (number <= 0) {
			System.out.println("Please enter a positive number.");
			sc.close();
			return;
		}

		int maxDigit = 10;
		int[] digits = new int[maxDigit];
		int index = 0;

		while (number != 0) {

			if (index == maxDigit) {
				maxDigit = maxDigit + 10;
				int[] temp = new int[maxDigit];

				for (int i = 0; i < index; i++) {
					temp[i] = digits[i];
				}

				digits = temp;
			}

			digits[index] = number % 10;
			index++;
			number = number / 10;
		}

		int largest = 0;
		int secondLargest = 0;

		for (int i = 0; i < index; i++) {
			int value = digits[i];

			if (value > largest) {
				secondLargest = largest;
				largest = value;
			} else if (value > secondLargest && value != largest) {
				secondLargest = value;
			}
		}

		System.out.println("Largest digit: " + largest);
		System.out.println("Second largest digit: " + secondLargest);

		sc.close();
	}

}
