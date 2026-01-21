package com.ioprogrammingpractice.csvdatahandling;

import java.io.FileReader;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;

public class ValidateEmployeesCSV {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9._]+$");
	private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

	public static void main(String[] args) {
		String filePath = "src/main/resources/validate_employees.csv";
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] row;
			int rowNumber = 1;

			reader.readNext();

			while ((row = reader.readNext()) != null) {
				rowNumber++;

				if (row.length < 4) {
					System.out.println("Row " + rowNumber + " Invalid column count");
					continue;
				}

				String name = row[1];
				String email = row[2];
				String phone = row[3];

				boolean valid = true;

				if (!EMAIL_PATTERN.matcher(email).matches()) {
					System.out.println("Row " + rowNumber + " Invalid Email: " + email);
					valid = false;
				}

				if (!PHONE_PATTERN.matcher(phone).matches()) {
					System.out.println("Row " + rowNumber + " Invalid Phone Number: " + phone);
					valid = false;
				}
				if (!valid) {
					System.out.println("  -> Invalid record for employee: " + name);
					System.out.println("--------------------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
