package com.dsapractice.runtimeanalysis;

import java.util.Arrays;

public class SortingComparison {

	// Bubble Sort
	static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Quick Sort
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		int[] data1 = { 5, 3, 8, 4, 2 };
		int[] data2 = data1.clone();
		int[] data3 = data1.clone();

		bubbleSort(data1);
		System.out.println("Bubble Sort: " + Arrays.toString(data1));

		Arrays.sort(data2);
		System.out.println("Merge Sort (Arrays.sort): " + Arrays.toString(data2));

		quickSort(data3, 0, data3.length - 1);
		System.out.println("Quick Sort: " + Arrays.toString(data3));
	}
}
