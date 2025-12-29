package com.oop.gcrcodebase.encapsulation.ecommerce;

import java.util.ArrayList;

public class ECommerceApp {
    public static void main(String[] args) {
        // Create product objects
        Product product1 = new Electronics(101,"Laptop", 100000);
        Product product2 = new Clothing(102, "T-Shirt", 150);
        Product product3 = new Groceries(103, "Onion", 50);

        // Create list of products (polymorphism)
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        // Loop through each product and print final price
        for (Product p : products) {
            System.out.println("Product ID   : " + p.getProductId());
            System.out.println("Name         : " + p.getName());
            System.out.println("Price        : ₹" + p.getPrice());

            double discount = p.calculateDiscount();
            double tax = 0;

            // Check if product is taxable
            if (p instanceof ITaxable) {
                tax = ((ITaxable) p).calculateTax();
                System.out.println("Tax          : ₹" + tax);
                System.out.println(((ITaxable) p).getTaxDetails());
            } else {
                System.out.println("Tax          : ₹0 (Not applicable)");
            }

            System.out.println("Discount     : ₹" + discount);

            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Final Price  : ₹" + finalPrice);
            System.out.println("------------------------------------");
        }
    }
}