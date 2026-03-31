package com.java8practice.functionalinterface.functional;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringLengthChecker {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your phone number: ");
		String num = sc.next();
		sc.close();


		if (!num.matches("[0-9]+")) {
			System.out.println("Only digits allowed");
			return;
		}

		Function<String, Integer> length = (s) -> s.length();
		Predicate<Integer> checkLength = (s) -> s == 10;
		if (checkLength.test(length.apply(num))) {
			System.out.println("Character under range for a valid phone number");
		} else {
			System.out.println("Character limit exceeded for a valid phone number!");
		}
	}
}
