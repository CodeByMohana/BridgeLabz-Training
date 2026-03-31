package com.controlflows;

import java.util.Scanner;

public class SumUsingForAndFormula {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int sum1 = (num * (num + 1)) / 2;
		int sum2 = 0;
		for (int i = 1; i <= num; i++) {
			sum2 += i;
		}
		System.out.println("The total using formulae: " + sum1 + " total using for loop: " + sum2);
		sc.close();
	}
}
