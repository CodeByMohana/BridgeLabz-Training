package com.collections.regex;

public class CensorBadWords {
	public static void main(String[] args) {
		String example = "This is a damn bad example with some stupid words.";
		String regex = "\\b(damn|stupid|bastard|fool)\\b";

		String censoredText = example.replaceAll(regex, "****");
		System.out.println(censoredText);
	}
}
