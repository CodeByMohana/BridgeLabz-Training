package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidHexCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regex = "^#[a-zA-Z0-9]{6}$";
		Pattern pattern = Pattern.compile(regex);
		System.out.print("Enter the Hex code: ");
		String hexCode = sc.next();
		Matcher matcher = pattern.matcher(hexCode);
		System.out.println(hexCode + " is valid: " + matcher.matches());
		sc.close();
	}
}
