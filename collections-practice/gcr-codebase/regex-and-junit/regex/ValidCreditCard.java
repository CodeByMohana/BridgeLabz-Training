package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidCreditCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the card number: ");
		String cardNumber = sc.next();
		sc.close();
		String regex = "^(4\\d{15}|5\\d{15})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNumber);
		System.out.println(cardNumber + " is valid: " + matcher.matches());
	}
}
