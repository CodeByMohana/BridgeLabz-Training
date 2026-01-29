package com.java8practice.functionalinterface.staticinterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {

	static String format(LocalDate date, String pattern) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		return date.format(formatter);
	}
}

public class DateFormat {
	public static void main(String[] args) {

		LocalDate today = LocalDate.now();

		System.out.println("Invoice: " + DateUtils.format(today, "dd-MM-yyyy"));

		System.out.println("Report: " + DateUtils.format(today, "yyyy/MM/dd"));

		System.out.println("US format: " + DateUtils.format(today, "MM-dd-yyyy"));
	}
}
