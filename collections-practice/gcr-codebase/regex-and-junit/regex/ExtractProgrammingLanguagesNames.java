package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguagesNames {
	public static void main(String[] args) {
		String example = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
		String regex = "\\b(Java|Python|JavaScript|Go)\\b";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(example);

		while (matcher.find()) {
			System.out.print(matcher.group() + ", ");
		}
	}
}
