package com.corejavapractice.gcrcodebase.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DigitFrequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int[] frequency = new int[10];
		int temp = number;
		while (temp > 0) {
			int digit = temp % 10;
			temp /= 10;
			frequency[digit]++;

		}
		System.out.println(Arrays.toString(frequency));
		sc.close();
	}
}
