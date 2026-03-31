package com.scenariobased.m1.set2;

import java.util.Scanner;

public class KeyGeneration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String validate = validate(input);
			if (validate != null) {
				System.out.println(validate);
			} else {
				String key = generate(input);
				if (key.length() == 0)
					System.out.println("Invalid Input (empty string)");
				else
					System.out.println(key);
			}

		}
		sc.close();
	}

	private static String generate(String input) {
		input = input.toLowerCase();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c % 2 != 0) {
				str.append(c);
			}
		}
		str = str.reverse();

		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
			}
		}

		return str.toString();
	}

	private static String validate(String input) {
		if (input.length() < 6)
			return "Invalid Input (length < 6)";
		if (input.contains(" "))
			return "Invalid Input (contains space)";
		if (input.matches(".*[0-9].*"))
			return "Invalid Input (contains digits)";
		if (input.matches(".*[^a-zA-Z].*"))
			return "Invalid Input (conatins special character)";
		return null;
	}
}
