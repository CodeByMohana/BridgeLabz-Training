package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class FilterStudentsCSVRecords {

	public static void main(String[] args) {

		String filePath = "src/main/resources/students.csv";

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

			String[] student;

			reader.readNext();

			while ((student = reader.readNext()) != null) {

				if (student.length < 4) {
					continue;
				}

				int id = Integer.parseInt(student[0]);
				String name = student[1];
				int age = Integer.parseInt(student[2]);
				int marks = Integer.parseInt(student[3]);

				if (marks > 80) {
					System.out.println("Student ID   : " + id);
					System.out.println("Name         : " + name);
					System.out.println("Age          : " + age);
					System.out.println("Marks        : " + marks);
					System.out.println("---------------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
