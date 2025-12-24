package com.corejavapractice.gcrcodebase.builtinfunctions;

import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = getInput(scanner);
		boolean result = isPalindrome(input);
		displayResult(input, result);
		scanner.close();
	}

	public static String getInput(Scanner scanner) {
		System.out.print("Enter a string: ");
		return scanner.nextLine().replaceAll("\\s+", "").toLowerCase();
	}

	public static boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static void displayResult(String str, boolean isPalindrome) {
		if (isPalindrome)
			System.out.println("\"" + str + "\" is a palindrome.");
		else
			System.out.println("\"" + str + "\" is not a palindrome.");
	}
}