package com.scenariobased.m1.set2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuizPerformanceRankingSystem {
	static class Student {
		String name;
		String department;
		int quiz1;
		int quiz2;
		int quiz3;

		public Student(String name, String department, int quiz1, int quiz2, int quiz3) {
			this.name = name;
			this.department = department;
			this.quiz1 = quiz1;
			this.quiz2 = quiz2;
			this.quiz3 = quiz3;
		}

		int getTotal() {
			return quiz1 + quiz2 + quiz3;
		}

		public String getName() {
			return name;
		}

		public String getDepartment() {
			return department;
		}

		public int getQuiz1() {
			return quiz1;
		}

		public int getQuiz2() {
			return quiz2;
		}

		public int getQuiz3() {
			return quiz3;
		}
	}

	static List<Student> records = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			String input = sc.nextLine();
			String[] parts = input.split(" ");

			String command = parts[0];

			switch (command) {

			case "Record":
				recordStudent(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
						Integer.parseInt(parts[5]));
				break;

			case "Top":

				if (parts[1].equals("Q1") || parts[1].equals("Q2") || parts[1].equals("Q3")) {
					topQuiz(parts[1]);
				} else {
					topDepartment(parts[1]);
				}

				break;
			}
		}

		sc.close();
	}

	// ---------------- OPERATIONS ----------------

	static void recordStudent(String name, String dept, int q1, int q2, int q3) {

		Student student = new Student(name, dept, q1, q2, q3);
		records.add(student);
		System.out.println("Record Added: " + name);

	}

	static void topDepartment(String dept) {

		// TODO: find student(s) with highest total score in this department
		List<Student> rec = records.stream().filter(d -> d.getDepartment().equals(dept)).toList();
		int max = rec.stream().mapToInt(Student::getTotal).max().orElse(-1);
		rec.stream().filter(s -> s.getTotal() == max)
				.forEach(t -> System.out.println(t.getName() + " " + t.getTotal()));
	}

	static void topQuiz(String quizName) {
		int max = 0;
		if (quizName.equals("Q1")) {
			max = records.stream().mapToInt(Student::getQuiz1).max().orElse(-1);
		}

		else if (quizName.equals("Q2")) {
			max = records.stream().mapToInt(Student::getQuiz2).max().orElse(-1);
		} else if (quizName.equals("Q3")) {
			max = records.stream().mapToInt(Student::getQuiz3).max().orElse(-1);
		}

		for (Student s : records) {
			int score = 0;
			if (quizName.equals("Q1")) {
				score = s.getQuiz1();
			} else if (quizName.equals("Q2")) {
				score = s.getQuiz2();
			} else if (quizName.equals("Q3")) {
				score = s.getQuiz3();
			}
			if (score == max) {
				System.out.println(s.getName() + " " + score);
			}
		}
	}

}
