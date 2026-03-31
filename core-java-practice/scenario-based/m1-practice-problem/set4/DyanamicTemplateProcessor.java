package com.scenariobased.m1.set4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DyanamicTemplateProcessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			System.out.println(processTemplate(input));
		}
		sc.close();
	}

	private static String processTemplate(String input) {
		String regex = "\\$\\{([A-Z]+):([^}]+)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		StringBuilder result = new StringBuilder();

		while (matcher.find()) {
			String type = matcher.group(1);
			String value = matcher.group(2);

			String replacement = convert(type, value);

			matcher.appendReplacement(result, replacement);
		}

		matcher.appendTail(result);
		return result.toString();
	}

	private static String convert(String type, String value) {
		switch (type) {
		case "UPPER":
			return value.toUpperCase();
		case "LOWER":
			return value.toLowerCase();
		case "DATE":
			try {
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");

				LocalDate date = LocalDate.parse(value, inputFormatter);

				return date.format(outputFormatter);
			} catch (Exception e) {
				return "INVALID";
			}

		case "REPEAT":
			String[] parts = value.split(",");
			StringBuilder string = new StringBuilder();
			string.repeat(parts[0], Integer.parseInt(parts[1]));
			return string.toString();

		default:
			return "INVALID";
		}

	}
}
