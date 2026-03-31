package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class NumberCheckArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter five numbers: ");
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				if (arr[i] % 2 == 0) {
					System.out.println("Even number: " + arr[i]);
				} else {
					System.out.println("Odd number: " + arr[i]);
				}
			} else if (arr[i] < 0) {
				System.out.println("Negative number: " + arr[i]);
			} else {
				System.out.println("The number is Zero" + arr[i]);
			}
		}
		if (arr[0] > arr[arr.length - 1]) {
			System.out.println(arr[0] + " is greater than the last element " + arr[arr.length - 1]);
		} else if (arr[0] < arr[arr.length - 1]) {
			System.out.println(arr[arr.length - 1] + " is greater than the last element " + arr[0]);
		} else {
			System.out.println("the first element and the last element are equal ");
		}
		sc.close();

	}
}
