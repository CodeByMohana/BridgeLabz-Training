package com.corejavapractice.gcrcodebase.strings;

import java.util.Scanner;

public class StringCharComparision {
	public char[] customCharArray(String string) {
		char[] charcters = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			charcters[i] = string.charAt(i);
		}
		return charcters;
	}

	public boolean compareCharArrays(char[] a, char[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String input = sc.next();
		StringCharComparision str = new StringCharComparision();
		char[] customResult = str.customCharArray(input);
		char[] builtInResult = input.toCharArray();
		boolean equal = str.compareCharArrays(customResult, builtInResult);
		System.out.print("Custom Method Result:");
		for (char c : customResult) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.print("Built-in toCharArray() Result :");
		for (char c : builtInResult) {
			System.out.print(c + " ");
		}
		System.out.println();

		System.out.println("Are both arrays equal? " + equal);
		sc.close();
	}

}
