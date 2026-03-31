package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class MeanHeight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[] heights = new double[11];
		double sum = 0;

		System.out.println("Enter the heights of 11 football players (in cm):");
		for (int i = 0; i < heights.length; i++) {
			System.out.print("Height of player " + (i + 1) + ": ");
			heights[i] = sc.nextDouble();
			sum += heights[i];
		}

		double mean = sum / 11;

		System.out.print("The mean height of the football players is: " + mean + "cm");

		sc.close();
	}
}
