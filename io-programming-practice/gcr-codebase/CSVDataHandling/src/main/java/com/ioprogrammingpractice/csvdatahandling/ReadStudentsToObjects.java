package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

class Student {
	private int id;
	private String name;
	private int age;
	private int marks;

	public Student(int id, String name, int age, int marks) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", marks=" + marks + '}';
	}

}

public class ReadStudentsToObjects {

	public static void main(String[] args) {
		String filePath = "src/main/resources/students.csv";
		List<Student> students = new ArrayList<>();

		try (CSVReader raeder = new CSVReader(new FileReader(filePath))) {
			String[] row;
			raeder.readNext(); // Skip header row

			while ((row = raeder.readNext()) != null) {

				if (row.length < 4) {
					continue; // Skip rows with insufficient data
				}

				int id = Integer.parseInt(row[0]);
				String name = row[1];
				int age = Integer.parseInt(row[2]);
				int marks = Integer.parseInt(row[3]);

				Student student = new Student(id, name, age, marks);
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Student student : students) {
			System.out.println(student);
		}

	}

}
