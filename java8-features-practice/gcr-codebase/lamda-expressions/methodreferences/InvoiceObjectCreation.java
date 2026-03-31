package com.java8practice.methodreferences;

import java.util.List;
import java.util.stream.*;

class Invoice {
	String item;
	double price;
	int quantity;

	public Invoice(String item, double price, int quantity) {
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

	public String toString() {
        return String.format("%s - Price: %.2f, Quantity: %d", item, price, quantity);
	}
}

public class InvoiceObjectCreation {
	public static void main(String[] args) {
		
		List<String> items = List.of("Pen", "Notebook", "Eraser");
		
		List<Invoice> invoices = items.stream()
			.map(item -> new Invoice(item, Math.random() * 100, (int)(Math.random() * 10) + 1))
			.collect(Collectors.toList());
		
		invoices.forEach(System.out::println);
	}
}
