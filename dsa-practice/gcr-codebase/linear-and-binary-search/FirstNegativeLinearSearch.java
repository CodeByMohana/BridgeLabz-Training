package com.dsapractice.linearandbinary;

public class FirstNegativeLinearSearch {

	// Method to find first negative number index
	public static int findFirstNegative(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				return i; // first negative found
			}
		}

		return -1; // no negative number
	}

	public static void main(String[] args) {

		int[] arr = { 5, 10, 3, -4, 9, -2 };

		int result = findFirstNegative(arr);

		System.out.println("Index of first negative number: " + result);
	}
}
