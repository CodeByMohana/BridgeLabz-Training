package com.corejavapractice.gcrcodebase.stringpractice;

import java.util.Scanner;

public class CountVowelsAndConsonants {

	public static int countConsonants(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			word = word.toLowerCase();
			char c = word.charAt(i);
			if (c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = sc.next().trim();
		int countConsonants = countConsonants(word);
		int countVowels = word.length() - countConsonants;
		System.out.println("Vowels Count: " + countVowels + "\nConsosnants count: " + countConsonants);
		sc.close();
	}
}
