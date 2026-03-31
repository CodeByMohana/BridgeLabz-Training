package com.oop.gcrcodebase.encapsulation.ecommerce;

public abstract class Product {
	private int productId;
	private String name;
	private double price;

	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public abstract double calculateDiscount();

	public void displayDetails() {
		System.out.println("Product ID   : " + productId);
		System.out.println("Name         : " + name);
		System.out.println("Price        : ₹" + price);
	}
}