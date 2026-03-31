package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class WriteEmployeeCSV {
	public static void main(String[] args) {
		String filePath = "src/main/resources/employees.csv";
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

			String[] header = { "ID", "Name", "Department", "Salary" };
			writer.writeNext(header);

			writer.writeNext(new String[] { "101", "John", "IT", "55000" });
			writer.writeNext(new String[] { "102", "Alice", "HR", "48000" });
			writer.writeNext(new String[] { "103", "Robert", "Finance", "62000" });
			writer.writeNext(new String[] { "104", "Emma", "Marketing", "50000" });
			writer.writeNext(new String[] { "105", "David", "IT", "75000" });
			System.out.println("employees.csv file written successfully!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
