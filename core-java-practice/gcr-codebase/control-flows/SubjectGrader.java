package com.controlflows;

import java.util.Scanner;

public class SubjectGrader {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter marks in Physics: ");
		int physics = sc.nextInt();

		System.out.print("Enter marks in Chemistry: ");
		int chemistry = sc.nextInt();

		System.out.print("Enter marks in Maths: ");
		int maths = sc.nextInt();

		int total = physics + chemistry + maths;
		double percentage = total / 3.0;

		String grade;
		if (percentage >= 80) {
			grade = "A (Level 4, above agency-normalized standards)";
		} else if (percentage >= 70) {
			grade = "B (Level 3, at agency-normalized standards)";
		} else if (percentage >= 60) {
			grade = "C (Level 2, below, but approaching agency-normalized standards)";
		} else if (percentage >= 50) {
			grade = "D (Level 1, well below agency-normalized standards)";
		} else if (percentage >= 40) {
			grade = "E (Level 1-, too below agency-normalized standards)";
		} else {
			grade = "R (Remedial standards)";
		}

		System.out.printf("Percentage: %.2f%%\n", percentage);
		System.out.println("Grade: " + grade);

		sc.close();
	}
}
