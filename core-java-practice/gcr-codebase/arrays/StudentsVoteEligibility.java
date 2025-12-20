package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class StudentsVoteEligibility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] age = new int[10];
		for (int i = 0; i < age.length; i++) {
			System.out.print("Enter the age of the student: ");
			age[i] = sc.nextInt();
			if (age[i] <= 0) {
				System.out.println("Enter a valid age again");
				i--;
			} else if (age[i] > 18) {
				System.out.println("Eligible to vote");
			} else {
				System.out.println("Not eligible to vote");
			}
		}
		sc.close();
	}

}
