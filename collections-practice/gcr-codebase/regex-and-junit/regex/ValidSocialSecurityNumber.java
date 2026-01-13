package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidSocialSecurityNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your SSN number: ");
		String socialSecurityNumber = sc.nextLine();
		sc.close();

		String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(socialSecurityNumber);

		if (matcher.find()) {
			System.out.println("Found SSN: " + matcher.group());
		} else {
			System.out.println("No valid SSN found.");
		}
	}
}
