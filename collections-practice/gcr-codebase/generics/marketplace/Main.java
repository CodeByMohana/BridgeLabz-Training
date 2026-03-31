package com.collections.generics.marketplace;

public class Main {
	public static void main(String[] args) {
		// Create products of various types
		Product<BookCategory> book = new Product<>("Java Programming", 40.0, BookCategory.TECHNOLOGY);
		Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 25.0, ClothingCategory.MENS);
		Product<GadgetCategory> phone = new Product<>("Smartphone", 300.0, GadgetCategory.MOBILE);

		// Create catalog
		ProductCatalog catalog = new ProductCatalog();
		catalog.addProduct(book);
		catalog.addProduct(shirt);
		catalog.addProduct(phone);

		System.out.println("=== Catalog Before Discount ===");
		catalog.displayCatalog();

		// Apply discounts using generic method
		DiscountUtil.applyDiscount(book, 10); // 10% discount on book
		DiscountUtil.applyDiscount(phone, 5); // 5% discount on phone

		System.out.println("\n=== Catalog After Discount ===");
		catalog.displayCatalog();
	}
}