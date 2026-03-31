package com.java8practice.collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {

	public static void main(String[] args) {
		String paragraph = "Java is great and Java is powerful";
		Map<String, Integer> frequency = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
				.collect(Collectors.toMap(word -> word, // key mapper
						word -> 1, // initial count
						Integer::sum // merge function for duplicates
				));
		System.out.println(frequency);
	}
}
