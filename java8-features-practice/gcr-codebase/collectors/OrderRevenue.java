package com.java8practice.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
	String customer;
	double amount;

	public Order(String customer, double amount) {
		this.customer = customer;
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public double getAmount() {
		return amount;
	}
}

public class OrderRevenue {
	public static void main(String[] args) {
		List<Order> orders = List.of(new Order("Alice", 120.50), new Order("Bob", 80.00), new Order("Alice", 40.00),
				new Order("Bob", 20.00), new Order("Charlie", 200.00));

		Map<String, Double> revenue = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getAmount)));
		System.out.println(revenue);
	}
}
