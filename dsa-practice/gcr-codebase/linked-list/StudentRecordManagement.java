package com.dsapractice.linkedlist;

class StudentNode {
	int rollNumber;
	String name;
	int age;
	int grade;
	StudentNode next;

	public StudentNode(int rollNumber, String name, int age, int grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}

}

interface StudentsManagement {
	// Add student at beginning
	void addStudentBeginning(int rollNumber, String name, int age, int grade);

	// Add student at ending
	void addStudentEnding(int rollNumber, String name, int age, int grade);

	// Add student at any position
	void addStudent(int position, int rollNumber, String name, int age, int grade);

	// Delete a student record
	void deleteRecord(int rollNumber);

	// Search a student record
	StudentNode searchRecord(int rollNumber);

	// Display all Record
	void displayStudents();

	// Update student grade
	void updateStudentGrade(int rollNumber, int newGrade);

}

public class StudentRecordManagement implements StudentsManagement {
	private StudentNode head;

	@Override
	public void addStudentBeginning(int rollNumber, String name, int age, int grade) {
		StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void addStudentEnding(int rollNumber, String name, int age, int grade) {

		if (head == null) {
			addStudentBeginning(rollNumber, name, age, grade);
			return;
		}
		StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

		StudentNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	@Override
	public void addStudent(int position, int rollNumber, String name, int age, int grade) {
		if(head == null && position > 1) {
			System.out.println("Invalid position as List is empty");
			return;
		}
		if (position <= 1) {
			addStudentBeginning(rollNumber, name, age, grade);
			return;
		}

		StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
		StudentNode temp = head;

		for (int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Invalid position");
			return;
		}
		newNode.next = temp.next;
		temp.next = newNode;

	}

	@Override
	public void deleteRecord(int rollNumber) {
		if (head == null) {
			System.out.println("List Is Empty");
			return;
		}
		if (head.rollNumber == rollNumber) {
			head = head.next;
			return;
		}
		StudentNode temp = head;
		while (temp.next != null && temp.next.rollNumber != rollNumber) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Student Not Found");
		} else {
			temp.next = temp.next.next;
		}
	}

	@Override
	public StudentNode searchRecord(int rollNumber) {
		if (head == null) {
			System.out.println("List Is Empty");
			return null;
		}
		StudentNode temp = head;
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				return temp;
			}
			temp = temp.next;
		}

		System.out.println("Student Not Found");
		return null;

	}

	@Override
	public void displayStudents() {
		if (head == null) {
			System.out.println("No student records found");
			return;
		}

		StudentNode temp = head;
		while (temp != null) {
			System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age
					+ ", Grade: " + temp.grade);
			temp = temp.next;
		}
	}

	@Override
	public void updateStudentGrade(int rollNumber, int newGrade) {
		StudentNode updateStudent = searchRecord(rollNumber);
		if (updateStudent == null) {
			System.out.println("Student not found");
		} else {
			updateStudent.grade = newGrade;
		}
	}

	public static void main(String[] args) {
		StudentRecordManagement srm = new StudentRecordManagement();

		srm.addStudentBeginning(1, "Alice", 18, 90);
		srm.addStudentEnding(2, "Bob", 19, 85);
		srm.addStudent(2, 3, "Charlie", 20, 88);

		srm.displayStudents();

		System.out.println("\nUpdating grade...");
		srm.updateStudentGrade(2, 95);

		System.out.println("\nAfter deletion...");
		srm.deleteRecord(1);
		srm.displayStudents();
	}
}
