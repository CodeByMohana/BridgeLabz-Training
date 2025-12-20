package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class EmployeeBonus {
	public static void main(String[] args) {
		final int EMPLOYEE_COUNT = 10;
		Scanner sc = new Scanner(System.in);

		double[] salaries = new double[EMPLOYEE_COUNT];
		double[] yearsOfService = new double[EMPLOYEE_COUNT];
		double[] bonusAmounts = new double[EMPLOYEE_COUNT];
		double[] newSalaries = new double[EMPLOYEE_COUNT];

		double totalBonus = 0;
		double totalOldSalary = 0;
		double totalNewSalary = 0;

		for (int i = 0; i < EMPLOYEE_COUNT; i++) {
			System.out.println("Enter details for Employee " + (i + 1));

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			if (salary <= 0) {
				System.out.println("Invalid salary. Please enter again.\n");
				i--;
				continue;
			}

			System.out.print("Enter years of service: ");
			double service = sc.nextDouble();
			if (service < 0) {
				System.out.println("Invalid years of service. Please enter again.\n");
				i--;
				continue;
			}

			salaries[i] = salary;
			yearsOfService[i] = service;
		}

		for (int i = 0; i < EMPLOYEE_COUNT; i++) {
			double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
			bonusAmounts[i] = salaries[i] * bonusRate;
			newSalaries[i] = salaries[i] + bonusAmounts[i];

			totalBonus += bonusAmounts[i];
			totalOldSalary += salaries[i];
			totalNewSalary += newSalaries[i];
		}

		System.out.println("\n--- Bonus and Salary Report ---");
		for (int i = 0; i < EMPLOYEE_COUNT; i++) {
			System.out.printf("Employee %d - Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n", i + 1, salaries[i],
					bonusAmounts[i], newSalaries[i]);
		}

		System.out.printf("\nTotal Bonus Payout: %.2f\n", totalBonus);
		System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
		System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
		sc.close();
	}
}
