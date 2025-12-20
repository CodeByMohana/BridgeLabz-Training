package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class BMI1DArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of persons: ");
		int n = sc.nextInt();

		double[] height = new double[n];
		double[] weight = new double[n];
		double[] bmi = new double[n];
		String[] status = new String[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details for Person " + (i + 1));

			System.out.print("Enter height (in meters): ");
			height[i] = sc.nextDouble();
			if (height[i] <= 0) {
				System.out.println("Invalid height. Try again.");
				i--;
				continue;
			}

			System.out.print("Enter weight (in kg): ");
			weight[i] = sc.nextDouble();
			if (weight[i] <= 0) {
				System.out.println("Invalid weight. Try again.");
				i--;
				continue;
			}

			bmi[i] = weight[i] / (height[i] * height[i]);

			if (bmi[i] <= 18.4) {
				status[i] = "Underweight";
			} else if (bmi[i] <= 24.9) {
				status[i] = "Normal";
			} else if (bmi[i] <= 39.9) {
				status[i] = "Overweight";
			} else {
				status[i] = "Obese";
			}
		}

		System.out.println("\n--- BMI Report ---");
		for (int i = 0; i < n; i++) {
			System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n", i + 1, height[i],
					weight[i], bmi[i], status[i]);
		}
		sc.close();
	}
}
