package com.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
	public static void main(String[] args) {
		String example = "The events are scheduled for 12/15/2023, 15/08/2024, and 29/02/2020.";
		String regex = "(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/[0-9]{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(example);

		while (matcher.find()) {
			System.out.print(matcher.group() + ", ");
		}
	}
}
