package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmail {
	public static void main(String[] args) {
		String example = "Contact us at support@example.com and info@company.org";
		String regex = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(example);

		while (matcher.find()) {
			System.out.println("Found: " + matcher.group());
		}
	}
}
