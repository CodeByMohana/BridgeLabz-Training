package com.corejavapractice.gcrcodebase.methods;

import java.util.Scanner;

public class AtheleteRounds {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sides of the triangle: ");
		System.out.print("Side A: ");
		double a = sc.nextDouble();
		System.out.print("Side B: ");
		double b = sc.nextDouble();
		System.out.print("Side C: ");
		double c = sc.nextDouble();
		double rounds = calculateRounds(a, b, c);
		System.out.printf("Number of rounds to complete 5km: %.2f", rounds);
		sc.close();
	}

	public static double calculateRounds(double a, double b, double c) {
		double perimeter = a + b + c;
		return 5000 / perimeter;
	}
}
