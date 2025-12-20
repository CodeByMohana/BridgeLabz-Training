package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class GradecalculatorInTwoDArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of students: ");
		int numStudents = sc.nextInt();

		int[][] marks = new int[numStudents][3]; // [Physics, Chemistry, Maths]
		double[] percentages = new double[numStudents];
		String[] grades = new String[numStudents];

		for (int i = 0; i < numStudents; i++) {
			System.out.println("\nEnter marks for Student " + (i + 1));

			for (int j = 0; j < 3; j++) {
				String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
				System.out.print("Enter marks for " + subject + ": ");
				int mark = sc.nextInt();

				if (mark < 0 || mark > 100) {
					System.out.println("Invalid marks! Please enter between 0 and 100.");
					j--;
					continue;
				}

				marks[i][j] = mark;
			}
		}

		for (int i = 0; i < numStudents; i++) {
			int total = marks[i][0] + marks[i][1] + marks[i][2];
			percentages[i] = total / 3.0;

			double perc = percentages[i];
			if (perc >= 80) {
				grades[i] = "A";
			} else if (perc >= 70) {
				grades[i] = "B";
			} else if (perc >= 60) {
				grades[i] = "C";
			} else if (perc >= 50) {
				grades[i] = "D";
			} else if (perc >= 40) {
				grades[i] = "E";
			} else {
				grades[i] = "R";
			}
		}

		System.out.println("\n--- Student Results ---");
		for (int i = 0; i < numStudents; i++) {
			System.out.printf("Student %d: Physics = %d, Chemistry = %d, Maths = %d, Percentage = %.2f%%, Grade = %s\n",
					i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
		}
		sc.close();
	}
}
