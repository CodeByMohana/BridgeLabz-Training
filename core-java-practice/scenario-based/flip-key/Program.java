package com.corejavapractice.scenariobased.flipkey;

import java.util.Scanner;

public class Program {
	public String cleanseAndInvert(String input) {
		if (input == null || input.length() < 6) {
			return "";
		}
		if (!input.matches("[A-Za-z]+")) {
			return "";
		}

		input = input.toLowerCase();

		StringBuilder ans = new StringBuilder();
		int position = 0;
		for (int i = input.length() - 1; i >= 0; i--) {

			char c = input.charAt(i);

			if (c % 2 != 0) {

				if (position % 2 == 0) {
					ans.append(Character.toUpperCase(c));
				} else {
					ans.append(c);
				}
				position++;
			}
		}
		return ans.toString();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Program p = new Program();

		System.out.println("Enter the word");
		String input = sc.nextLine();

		String result = p.cleanseAndInvert(input);

		if (result.isEmpty()) {
			System.out.println("Invalid Input");
		} else {
			System.out.println("The generated key is - " + result);
		}

		sc.close();
	}
}
