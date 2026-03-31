package com.corejavapractice.gcrcodebase.strings;

import java.util.Scanner;

public class CompareStrings {
	public boolean compare(String stringOne, String stringTwo) {
		if (stringOne.length() > stringTwo.length() || stringOne.length() < stringTwo.length())
			return false;
		for (int i = 0; i < stringOne.length(); i++) {
			if (stringOne.charAt(i) != stringTwo.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String stringOne = sc.next();
		System.out.print("Enter a string: ");
		String stringTwo = sc.next();
		CompareStrings method = new CompareStrings();
		System.out.println(method.compare(stringOne, stringTwo));
		sc.close();
	}
}
