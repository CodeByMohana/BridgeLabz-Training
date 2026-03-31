package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class SearchEmployeeCSV {
	public static void main(String[] args) {
		String filePath = "src/main/resources/employees.csv";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee name to search: ");
		String searchName = sc.nextLine().trim();
		boolean found = false;

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] employee;
			reader.readNext();

			while ((employee = reader.readNext()) != null) {

				if (employee.length < 4) {
					continue;
				}

				String name = employee[1];

				if (name.equalsIgnoreCase(searchName)) {

					String department = employee[2];
					String salary = employee[3];
					System.out.println("Employee Found!");
					System.out.println("Name       : " + name);
					System.out.println("Department : " + department);
					System.out.println("Salary     : " + salary);

					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Employee not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();

	}
}
