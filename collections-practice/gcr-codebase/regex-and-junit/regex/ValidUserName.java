package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUserName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
		Pattern pattern = Pattern.compile(regex);
		String userName = sc.next();
		Matcher matcher = pattern.matcher(userName);
		System.out.println(userName + " is valid: " + matcher.matches());

		sc.close();
	}

}
