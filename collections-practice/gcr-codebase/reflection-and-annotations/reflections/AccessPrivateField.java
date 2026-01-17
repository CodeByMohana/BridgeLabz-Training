package com.collections.reflections;

import java.lang.reflect.Field;

class Person {
	private int age = 20;

	public void showAge() {
		System.out.println("Age (via method): " + age);
	}

}

public class AccessPrivateField {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		
		// Load class object
		Class<?> cls = person.getClass();
		
		//Get field
		Field ageField = cls.getDeclaredField("age");
		
		//BREAK encapsulation
		ageField.setAccessible(true);
		
		//Modify private field
		ageField.setInt(person, 25);
		
		//Retrieve private field value
		int ageValue = ageField.getInt(person);
		
		System.out.println("Age (via reflection): " + ageValue);
		
		person.showAge();
	}
}
