package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class CountCSVRows {
	public static void main(String[] args) {
		String filePath = "src/main/resources/students.csv";
		int count = 0;

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			reader.readNext();
			while (reader.readNext() != null) {
				count++;
			}
			System.out.println("Number of student records: " + count);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
