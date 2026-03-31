package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksExtractor {
	public static void main(String[] args) {
		String example = "Visit https://www.google.com and http://example.org for more info.";
		String regex = "(https?://|www\\.)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(example);
		
		while(matcher.find()) {
			System.out.println("Link: " + matcher.group());
		}
	}
}
