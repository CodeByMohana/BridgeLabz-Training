package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.opencsv.CSVReader;

public class SortEmployeesBySalary {
	static class Employee {
		int id;
		String name;
		String department;
		double salary;

		Employee(int id, String name, String department, double salary) {
			this.id = id;
			this.name = name;
			this.department = department;
			this.salary = salary;
		}
	}

	public static void main(String[] args) {

		String filePath = "src/main/resources/employees.csv";
		List<Employee> employees = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

			String[] row;

			reader.readNext();

			while ((row = reader.readNext()) != null) {

				if (row.length < 4) {
					continue;
				}

				int id = Integer.parseInt(row[0]);
				String name = row[1];
				String department = row[2];
				double salary = Double.parseDouble(row[3]);

				employees.add(new Employee(id, name, department, salary));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		employees.sort(Comparator.comparingDouble((Employee e) -> e.salary).reversed());

		System.out.println("Top 5 Highest-Paid Employees");
		System.out.println("--------------------------------");

		int limit = Math.min(5, employees.size());

		for (int i = 0; i < limit; i++) {
			Employee e = employees.get(i);

			System.out.println("ID         : " + e.id);
			System.out.println("Name       : " + e.name);
			System.out.println("Department : " + e.department);
			System.out.println("Salary     : " + e.salary);
			System.out.println("--------------------------------");
		}
	}
}
