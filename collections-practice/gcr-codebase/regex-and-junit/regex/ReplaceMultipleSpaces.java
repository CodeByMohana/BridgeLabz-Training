package com.collections.regex;

public class ReplaceMultipleSpaces {
	public static void main(String[] args) {
		String example = "This is an   example   with multiple   spaces.   ";
		String regex = "\\s+";

		String replacedText = example.replaceAll(regex, " ");
		System.out.println("Replaced Text: " + replacedText);

	}
}
