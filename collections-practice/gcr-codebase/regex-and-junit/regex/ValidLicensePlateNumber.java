package com.collections.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidLicensePlateNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regex = "^[A-Z]{2}[0-9]{4}$"; // in place of [0-9] we can also use "//d"
		Pattern pattern = Pattern.compile(regex);
		System.out.print("Enter the License Plate Number: ");
		String plateNumber = sc.next();
		Matcher matcher = pattern.matcher(plateNumber);
		System.out.println(plateNumber + " is valid: " + matcher.matches());
		sc.close();
	}
}
