package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class UpdateEmployeeSalaryCSV {
	public static void main(String[] args) {
		String inputFile = "src/main/resources/employees.csv";

		String outputFile = "src/main/resources/employees_updated.csv";

		try (CSVReader reader = new CSVReader(new FileReader(inputFile));
				CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
			String[] employee;
			employee = reader.readNext();
			writer.writeNext(employee);

			while ((employee = reader.readNext()) != null) {

				if (employee.length < 4) {
					continue;
				}

				int id = Integer.parseInt(employee[0]);
				String name = employee[1];
				String department = employee[2];
				double salary = Double.parseDouble(employee[3]);

				if (department.equalsIgnoreCase("IT")) {
					salary = salary + (salary * 0.10);
				}

				writer.writeNext(new String[] { String.valueOf(id), name, department, String.valueOf(salary) });

			}

			System.out.println("Updated CSV file created successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
