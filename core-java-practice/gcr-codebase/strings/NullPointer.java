package com.corejavapractice.gcrcodebase.strings;

public class NullPointer {
	public void generateException() {
		String text = null;
		int length = text.length();
		System.out.println("Text length: " + length);
	}

	public void handleException() {
		String text = null;
		try {
			int length = text.length();
			System.out.println("Text length: " + length);
		} catch (NullPointerException e) {
			System.out.println("Caught a NullPointerException : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Caught a RunTimeException : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("--- Generating NullPointerException (No Handling) ---");
		NullPointer n = new NullPointer();
		try {
			n.generateException();
		} catch (NullPointerException e) {
			System.out.println("Caught in main: " + e.getMessage());
		}

		System.out.println("--- Handling NullPointerException (With try-catch) ---");
		n.handleException();
	}
}
