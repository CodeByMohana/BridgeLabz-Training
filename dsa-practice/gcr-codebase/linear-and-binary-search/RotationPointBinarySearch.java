package com.dsapractice.linearandbinary;

public class RotationPointBinarySearch {

	// Method to find rotation point index
	public static int findRotationPoint(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left; // index of smallest element
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 7, 1, 2, 3 };

		int index = findRotationPoint(arr);

		System.out.println("Rotation point index: " + index);
		System.out.println("Smallest element: " + arr[index]);
	}
}
