package com.dsapractice.runtimeanalysis;

import java.util.Arrays;

public class SearchComparison {

	// Linear Search
	static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}

	// Binary Search (array must be sorted)
	static int binarySearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] data = new int[100000];
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
		}

		int target = 99999;

		long start = System.nanoTime();
		linearSearch(data, target);
		long end = System.nanoTime();
		System.out.println("Linear Search Time: " + (end - start) + " ns");

		Arrays.sort(data);

		start = System.nanoTime();
		binarySearch(data, target);
		end = System.nanoTime();
		System.out.println("Binary Search Time: " + (end - start) + " ns");
	}
}
