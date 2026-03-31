package com.corejavapractice.gcrcodebase.methods;

import java.util.Scanner;

public class SimpleInterest {
	public double interstCalculator(double principal, double interest, double years) {
		return (principal * interest * years) / 100;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the principal amount: ");
		double amount = sc.nextDouble();
		System.out.print("Enter the rate of interest: ");
		double interest = sc.nextDouble();
		System.out.print("Enter the time period in years: ");
		double years = sc.nextDouble();
		SimpleInterest s = new SimpleInterest();
		System.out.println("The Simple Interest is " + s.interstCalculator(amount, interest, years) + " for Principal "
				+ amount + " Rate of Interest " + interest + " and Time " + years);
		sc.close();

	}
}
