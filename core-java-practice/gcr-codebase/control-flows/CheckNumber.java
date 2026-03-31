package com.controlflows;

import java.util.Scanner;

public class CheckNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check wether it is positive, negative or zero: ");
		int number = sc.nextInt();
		if (number > 0) {
			System.out.println("Entered number is positive");
		} else if (number < 0) {
			System.out.println("Entered number is negative");
		} else {
			System.out.println("Entered number is zero");
		}
		sc.close();
	}
}
