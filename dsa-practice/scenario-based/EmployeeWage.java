package com.scenariobased;

public class EmployeeWage {

	// Instance variables
	int wagePerHour = 20;
	int fullDayHour = 8;
	int partTimeHour = 4;
	int maxWorkingDays = 20;
	int maxWorkingHours = 100;

	// Method to calculate employee wage
	public void calculateWage() {

		int totalWorkingDays = 0;
		int totalWorkingHours = 0;
		int totalWage = 0;

		System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

		while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {

			totalWorkingDays++;

			int empCheck = (int) (Math.random() * 3);
			int empHours = 0;

			switch (empCheck) {
			case 1:
				empHours = fullDayHour;
				System.out.println("Day " + totalWorkingDays + ": Employee is Full Time");
				break;

			case 2:
				empHours = partTimeHour;
				System.out.println("Day " + totalWorkingDays + ": Employee is Part Time");
				break;

			default:
				empHours = 0;
				System.out.println("Day " + totalWorkingDays + ": Employee is Absent");
			}

			totalWorkingHours += empHours;
			int dailyWage = empHours * wagePerHour;
			totalWage += dailyWage;

			System.out.println("Daily Wage: " + dailyWage);
			System.out.println("-------------------------");
		}

		System.out.println("Total Working Days: " + totalWorkingDays);
		System.out.println("Total Working Hours: " + totalWorkingHours);
		System.out.println("Total Monthly Wage: " + totalWage);
	}

	// Main method
	public static void main(String[] args) {
		EmployeeWage employee = new EmployeeWage();
		employee.calculateWage();
	}
}
