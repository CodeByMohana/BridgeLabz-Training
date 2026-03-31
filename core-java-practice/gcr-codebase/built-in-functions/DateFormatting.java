package com.corejavapractice.gcrcodebase.builtinfunctions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
		System.out.println("Format 1 (dd/MM/yyyy): " + currentDate.format(formatter1));
		System.out.println("Format 2 (yyyy-MM-dd): " + currentDate.format(formatter2));
		System.out.println("Format 3 (EEE, MMM dd, yyyy): " + currentDate.format(formatter3));
	}
}