package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValues {
	public static void main(String[] args) {
		String example = "The price is $45.998, and the discount is 10.50.";
		String regex = "\\$?\\d+\\.\\d{2}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(example);
		
		while(matcher.find()) {
			System.out.print(matcher.group() + ", ");
		}
	}
}
