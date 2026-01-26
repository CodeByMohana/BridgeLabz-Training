package com.java8practice.lamdaexpressions;

import java.util.Arrays;
import java.util.List;

class Product {
	String name;
	double price;
	double rating;
	double discount;

	public Product(String n, double p, double r, double d) {
		name = n;
		price = p;
		rating = r;
		discount = d;
	}

	public String toString() {
		return name + " " + price + " " + rating + " " + discount;
	}
}


public class Shop {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Phone", 800, 4.5, 10),
                new Product("Laptop", 1200, 4.8, 15),
                new Product("Watch", 300, 4.2, 20)
        );

		// by price
        products.sort((a, b) -> Double.compare(a.price, b.price));

        // by rating
        products.sort((a, b) -> Double.compare(b.rating, a.rating));

        // by discount
        products.sort((a, b) -> Double.compare(b.discount, a.discount));

        products.forEach(System.out::println);
    }
}

