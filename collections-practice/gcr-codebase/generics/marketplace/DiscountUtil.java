package com.collections.generics.marketplace;

public class DiscountUtil {
	public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
		double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
		product.setPrice(discountedPrice);
		System.out.println("Discount applied: " + product.getName() + " new price = $" + discountedPrice);
	}
}
