package com.scenariobased.m1.set3;

import java.util.Scanner;

public class CorporateEmailAccessControl {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			String email = sc.nextLine().trim();

			if (validateEmail(email)) {
				System.out.println("Access Granted");
			} else {
				System.out.println("Access Denied");
			}
		}

		sc.close();
	}

	// ---------------- EMAIL VALIDATION ----------------

	private static boolean validateEmail(String email) {

		if (email.matches("^[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com$")) {
			return true;
		}
		return false;
	}
}
