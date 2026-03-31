package com.collections.generics.warehouse;

public class Main {
	public static void main(String[] args) {
		// Create storages
		Storage<Electronics> electronicsStorage = new Storage<>();
		Storage<Groceries> groceriesStorage = new Storage<>();
		Storage<Furniture> furnitureStorage = new Storage<>();

		// Add items
		electronicsStorage.addItem(new Electronics("Laptop", 1200));
		electronicsStorage.addItem(new Electronics("Smartphone", 800));

		groceriesStorage.addItem(new Groceries("Rice", 50));
		groceriesStorage.addItem(new Groceries("Milk", 20));

		furnitureStorage.addItem(new Furniture("Chair", 150));
		furnitureStorage.addItem(new Furniture("Table", 300));

		// Display all items using wildcard
		System.out.println("=== Electronics ===");
		WarehouseUtils.displayItems(electronicsStorage.getAllItems());

		System.out.println("\n=== Groceries ===");
		WarehouseUtils.displayItems(groceriesStorage.getAllItems());

		System.out.println("\n=== Furniture ===");
		WarehouseUtils.displayItems(furnitureStorage.getAllItems());
	}
}
