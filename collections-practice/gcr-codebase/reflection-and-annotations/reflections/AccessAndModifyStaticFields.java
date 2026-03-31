package com.collections.reflections;

import java.lang.reflect.Field;

class Configuration {
	private static String API_KEY = "OLD_KEY_ACC1234556DEF";

	public static void display() {
		System.out.println("API_KEY: " + API_KEY);
	}
}

public class AccessAndModifyStaticFields {
	public static void main(String[] args) {
		try {
			System.out.print("Before Modification ");
			Configuration.display();

			Class<?> cls = Configuration.class;

			Field field = cls.getDeclaredField("API_KEY");

			field.setAccessible(true);

			field.set(null, "NEW_KEY_ABC123$56");

			System.out.print("After Modification ");
			Configuration.display();

		} catch (Exception e) {
			System.out.println("An error occurred");
		}
	}
}
