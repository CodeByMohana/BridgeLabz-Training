package com.scenariobased.m1.set1;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class GlobalShipmentManifestRecord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String record = sc.nextLine();
			if (validateRecord(record)) {
				System.out.println("COMPLIANT RECORD");
			} else {
				System.out.println("NON-COMPLIANT RECORD");
			}
		}
		sc.close();
	}

	private static boolean validateRecord(String record) {
		String[] parts = record.split("\\|");
		if (parts.length != 5) {
			return false;
		}

		String code = parts[0];
		String date = parts[1];
		String mode = parts[2];
		String weight = parts[3];
		String status = parts[4];
		return validateCode(code) && validateDate(date) && validateMode(mode) && validateWeight(weight)
				&& validateStatus(status);
	}

	private static boolean validateStatus(String status) {
		Set<String> statuses = Set.of("DELIVERED", "CANCELLED", "IN_TRANSIT");
		return statuses.contains(status);
	}

	private static boolean validateWeight(String weight) {
		if (weight.startsWith("0") && weight.length() > 1 && weight.charAt(1) != '.')
			return false;

		int dot = weight.indexOf(".");
		if (dot != -1) {
			int decimals = weight.length() - dot - 1;
			if (decimals > 2)
				return false;
		}
		double w;
		try {
			 w = Double.parseDouble(weight);
		} catch (Exception e) {
			return false;
		}
		return w > 0 && w <= 999999.99;
	}

	private static boolean validateMode(String mode) {
		Set<String> modes = Set.of("AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT");
		return modes.contains(mode);
	}

	private static boolean validateDate(String date) {
		if (!date.matches("20\\d{2}-\\d{2}-\\d{2}"))
			return false;
		try {
			LocalDate.parse(date);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static boolean validateCode(String code) {
		if (!code.matches("SHIP-[1-9][0-9]{5}")) {
			return false;
		}

		String digits = code.substring(5);
		int count = 1;
		for (int i = 1; i < digits.length(); i++) {
			if (digits.charAt(i) == digits.charAt(i - 1)) {
				count++;
				if (count > 3)
					return false;
			} else {
				count = 1;
			}
		}
		return true;
	}

}
