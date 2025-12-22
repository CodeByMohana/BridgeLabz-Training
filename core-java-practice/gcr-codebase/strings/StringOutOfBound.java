package com.corejavapractice.gcrcodebase.strings;

import java.util.Scanner;

public class StringOutOfBound {
	public void generateException(String text) {
		char character = text.charAt(text.length());
		System.out.println("Character: " + character);
	}

	public void handleException(String text) {
		try {
			char ch = text.charAt(text.length());
			System.out.println("Character: " + ch);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Caught StringOutOfBoundException : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Caught RunTimeException : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String input = sc.next();
		System.out.println("--- Generating Exception (No Handling) ---");
		StringOutOfBound str = new StringOutOfBound();
		try {
			str.generateException(input);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Caught in main: " + e.getMessage());
		}

		System.out.println("\n--- Handling Exception (With try-catch) ---");
		str.handleException(input);
		sc.close();

	}
}
