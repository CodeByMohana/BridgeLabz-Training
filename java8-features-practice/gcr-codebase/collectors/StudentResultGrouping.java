package com.java8practice.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	private String name;
	private String grade;

	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}
}

public class StudentResultGrouping {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Ravi", "A"), new Student("Sneha", "A"),
				new Student("Kiran", "B"), new Student("Arjun", "B"), new Student("Meena", "C"));

		Map<String, List<String>> result = students.stream().collect(
				Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));
		System.out.println(result);

	}
}
