package com.java8practice.methodreferences;

import java.util.Arrays;
import java.util.List;

public class NameUppercasing {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Mohana", "Sai", "Rahul", "Priya");
		
		names.stream().map(String :: toUpperCase).forEach(System.out::println);
	}
}
 