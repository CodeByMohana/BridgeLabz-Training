package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class ReadStudentCSV {
	public static void main(String[] args) {
		String filePath = "src/main/resources/students.csv";
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] student;
			reader.readNext();
			while ((student = reader.readNext()) != null) {
				System.out.println("Student ID   : " + student[0]);
				System.out.println("Name         : " + student[1]);
				System.out.println("Age          : " + student[2]);
				System.out.println("Marks        : " + student[3]);
				System.out.println("---------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
