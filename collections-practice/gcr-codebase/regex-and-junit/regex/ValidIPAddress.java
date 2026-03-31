package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIPAddress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the IP address: ");
		String address = sc.next();
		sc.close();

		String regex = "^(25[0-5]|2[0-4]\\d|1[0-9]\\d\\d|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1[0-9]\\d\\d|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1[0-9]\\d\\d|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1[0-9]\\d\\d|[1-9]?\\d)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(address);

		System.out.println(address + " is vaild: " + matcher.matches());

	}
}
