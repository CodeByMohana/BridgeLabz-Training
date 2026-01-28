package com.scenariobased.string;

import java.util.Scanner;

public class LexicalTwist {

	static boolean contains(char[] arr, int size, char c) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == c) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the forst word: ");
		String firstWord = scanner.nextLine();
		System.out.print("Enter the second word: ");
		String secondWord = scanner.nextLine();
		scanner.close();
		
		if (firstWord.trim().contains(" ")) {
		    System.out.println(firstWord + " is an invalid word");
		    return;
		}
		if (secondWord.trim().contains(" ")) {
		    System.out.println(secondWord + " is an invalid word");
		    return;
		}

		StringBuffer first = new StringBuffer(firstWord);
		StringBuffer second = new StringBuffer(secondWord);

		if (second.reverse().toString().equalsIgnoreCase(firstWord)) {
			String result = first.reverse().toString().toLowerCase();

			// using Rejex to replace all vowels with @
			result = result.replaceAll("[aeiou]", "@");

			System.out.println("Transformed Word: " + result);
		} else {
			first.append(second);
			String result = first.toString().toUpperCase();
			int vowels = 0;
			int consonants = 0;
			char[] vowel = new char[2];
			char[] consonant = new char[2];

			int vIndex = 0, cIndex = 0;
			for (char c : result.toCharArray()) {

				// checking the wether the character is available in in AEIOU string
				boolean isVowel = "AEIOU".indexOf(c) != -1;

				if (isVowel) {
					vowels++;

					if (vIndex < 2 && !contains(vowel, vIndex, c)) {
						vowel[vIndex++] = c;
					}

				} else {
					consonants++;
					if (cIndex < 2 && !contains(consonant, cIndex, c)) {
						consonant[cIndex++] = c;
					}
				}
			}

			if (vowels > consonants) {
				System.out.println("First two unique vowels: " + vowel[0] + vowel[1]);
			} else if (consonants > vowels) {
				System.out.println("First two unique consonants: " + consonant[0] + consonant[1]);

			} else {
				System.out.println("Vowels and consonants are equal");
			}
		}

	}

}
