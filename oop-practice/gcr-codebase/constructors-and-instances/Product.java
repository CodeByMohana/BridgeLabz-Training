package com.oop.gcrcodebase.constructorsandinstances;
//Create a Product class with:

//Instance Variables: productName, price.
//Class Variable: totalProducts (shared among all products).
//Methods:
//An instance method displayProductDetails() to display the details of a product.
//A class method displayTotalProducts() to show the total number of products created.

public class Product {
	// Instance Variables
	private String productName;
	private double price;

	// Class Variables
	private static int totalProducts = 0;

	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
		totalProducts++;
	}

	// Instance method to display product details
	public void displayProductDetails() {
		System.out.println("Product Name: " + productName);
		System.out.println("Price: " + price);
	}

	// Class method to display total number of products
	public static void displayTotalProducts() {
		System.out.println("Total Products Created: " + totalProducts);
	}

	public static void main(String[] args) {
		Product p1 = new Product("Laptop", 59999.99);
		Product p2 = new Product("Smartphone", 24999.50);

		p1.displayProductDetails();
		System.out.println();

		p2.displayProductDetails();
		System.out.println();

		Product.displayTotalProducts();
	}
}
