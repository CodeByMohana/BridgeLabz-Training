package com.oop.gcrcodebase.thisstaticinstanceof;

public class Employee {
	// Static variables
	private static String companyName = "ABC Company";
	private static int totalEmployees = 0;

	// Instance variables
	private String name;
	private String designation;

	// Final instance variable (cannot be changed once set)
	private final int id;

	// Constructor
	public Employee(String name, String designation, int id) {
		this.name = name;
		this.designation = designation;
		this.id = id;
		totalEmployees++;
	}

	// Static method to display total employees
	public static void displayTotalEmployees() {
		System.out.println("Total Employees: " + totalEmployees);
	}

	// Non Static display employee details method
	public void displayEmployeeDetails() {
		if (this instanceof Employee) {
			System.out.println("Company Name: " + companyName);
			System.out.println("Employee Name: " + name);
			System.out.println("Employee Designation: " + designation);
			System.out.println("Employee ID: " + id);
			System.out.println("------------------------------");
		} else {
			System.out.println("Invalid object.");
		}
	}

	// Main Method
	public static void main(String[] args) {
		Employee e1 = new Employee("Rohan", "Manager", 1034121);
		Employee e2 = new Employee("Rudra", "Team Leader", 1034132);

		e1.displayEmployeeDetails();
		e2.displayEmployeeDetails();

		Employee.displayTotalEmployees();
	}

}