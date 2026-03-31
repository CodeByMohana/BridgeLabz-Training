package com.collections.generics.marketplace;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	private List<Product<?>> products; // Holds any type of product

	public ProductCatalog() {
		products = new ArrayList<>();
	}

	public void addProduct(Product<?> product) {
		products.add(product);
	}

	public void displayCatalog() {
		for (Product<?> product : products) {
			System.out.println(product);
		}
	}
}