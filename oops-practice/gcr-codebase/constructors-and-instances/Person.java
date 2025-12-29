package com.oop.gcrcodebase.constructorsandinstances;

public class Person {
	private String name;
	private int age;

	// Parameterized constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Copy Constructor
	public Person(Person other) {
		this.name = other.name;
		this.age = other.age;
	}

	// Display method
	public void display() {
		System.out.println("Name: " + name + ", Age: " + age);
	}

	// Main method to test
	public static void main(String[] args) {
		Person original = new Person("Alice", 30);
		Person clone = new Person(original); // Copy constructor used

		System.out.println("Original Person:");
		original.display();

		System.out.println("Cloned Person:");
		clone.display();
	}
}
