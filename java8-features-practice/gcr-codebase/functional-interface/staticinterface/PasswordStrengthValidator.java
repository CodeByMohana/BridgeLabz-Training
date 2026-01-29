package com.java8practice.functionalinterface.staticinterface;

import java.util.Scanner;

interface SecurityUtils {
	static boolean isStrongpassword(String password) {
		if (password == null)
			return false;

		String regex = "^(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*\\d)" + "(?=.*[@$!#%?&])" + ".{8,}$";
		return password.matches(regex);
	}
}

public class PasswordStrengthValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Password: ");
		String password = sc.nextLine();

		if (SecurityUtils.isStrongpassword(password)) {
			System.out.println("Strong password");
		} else {
			System.out.println("Weak password");
		}
		sc.close();
	}
}
