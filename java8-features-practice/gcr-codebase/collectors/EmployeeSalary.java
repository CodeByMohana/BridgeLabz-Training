package com.java8practice.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private String department;
	private double salary;

	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalary {
	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Alice", "IT", 80000), new Employee("Bob", "IT", 90000),
				new Employee("Charlie", "HR", 60000), new Employee("David", "HR", 65000),
				new Employee("Eve", "Finance", 75000));
		Map<String, Double> averageSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalaryByDept);

	}
}
