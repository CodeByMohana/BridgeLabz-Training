package com.collections.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Employee implements Serializable {

	int id;
	String name;
	String department;
	double salary;

	Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
}

public class EmployeeSerialization {

	public static void main(String[] args) {

		String fileName = "employees.ser";

		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Sai", "IT", 50000));
		list.add(new Employee(2, "Ravi", "HR", 40000));

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(list);
			oos.close();
			System.out.println("Employees saved successfully");

		} catch (IOException e) {
			System.out.println("Error during serialization");
		}

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			ArrayList<Employee> empList = (ArrayList<Employee>) ois.readObject();
			ois.close();

			for (Employee e : empList) {
				System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error during deserialization");
		}
	}
}
