package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedWords {
	public static void main(String[] args) {
		String example = "This is is a repeated repeated word test.";
		String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(example);

		while (matcher.find()) {
			System.out.println("Repeated words: " + matcher.group(1));
		}
	}
}
