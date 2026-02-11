package com.java8practice.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDisplay {
	public static void main(String[] args) {
		List<String> customers = Arrays.asList("mohana", "ravi", "anita", "kiran", "sneha");
		
		List<String> result = customers.stream()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		
		result.forEach(System.out::println);
	}
}
