package com.corejavapractice.gcrcodebase.strings;

import java.util.Scanner;

public class SubstringComparision {
	public String subString(String string, int start, int end) {
		String result = "";
		for (int i = start; i < end; i++) {
			result += string.charAt(i);
		}
		return result;
	}

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
		System.out.print("Enter the string: ");
		String word = sc.next();
		System.out.print("Enter the start index: ");
		int start = sc.nextInt();
		System.out.print("Enter the end index: ");
		int end = sc.nextInt();
		SubstringComparision sub = new SubstringComparision();
		String subStringUser = sub.subString(word, start, end);
		String subStringPre = word.substring(start,end);
		System.out.println(sub.compare(subStringUser, subStringPre));
		sc.close();
		
	}

}
