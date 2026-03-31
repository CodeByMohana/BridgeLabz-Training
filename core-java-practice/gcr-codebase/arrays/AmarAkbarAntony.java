package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class AmarAkbarAntony {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] names = { "Amar", "Akbar", "Anthony" };
		int[] ages = new int[3];
		float[] heights = new float[3];

		for (int i = 0; i < 3; i++) {
			System.out.print("Enter age of " + names[i] + ": ");
			ages[i] = sc.nextInt();
			System.out.print("Enter height of " + names[i] + " (in cm): ");
			heights[i] = sc.nextFloat();
		}

		int minAge = ages[0];
		int youngestIndex = 0;

		for (int i = 1; i < 3; i++) {
			if (ages[i] < minAge) {
				minAge = ages[i];
				youngestIndex = i;
			}
		}

		float maxHeight = heights[0];
		int tallestIndex = 0;

		for (int i = 1; i < 3; i++) {
			if (heights[i] > maxHeight) {
				maxHeight = heights[i];
				tallestIndex = i;
			}
		}

		System.out.println("Youngest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
		System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
		sc.close();
	}

}
