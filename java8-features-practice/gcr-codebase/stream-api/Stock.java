package com.java8practice.streamapi;

import java.util.Arrays;
import java.util.List;

public class Stock {
	public static void main(String[] args) {
		List<Double> prices = Arrays.asList(150.5, 200.75, 300.0, 250.25, 400.0, 350.5);

		prices.stream().forEach(price -> System.out.println("Stock Price: $" + price));
	}
}
