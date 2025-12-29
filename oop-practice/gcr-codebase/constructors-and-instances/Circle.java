package com.oop.gcrcodebase.constructorsandinstances;

public class Circle {
	// Attributes
	public double radius;

	public Circle() {
		this(0.0); // calls parameterized constructor
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	// Method to display circle info
	public void display() {
		System.out.println("Radius: " + radius);
		System.out.println("Area: " + getArea());
	}

	public static void main(String[] args) {
		Circle c1 = new Circle(); // Uses default constructor
		Circle c2 = new Circle(5.5); // Uses parameterized constructor

		System.out.println("Circle 1:");
		c1.display();

		System.out.println("\nCircle 2:");
		c2.display();
	}

}
