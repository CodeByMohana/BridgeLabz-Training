package com.collections.reflections;

import java.lang.reflect.Constructor;

class Student {
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class DynamicObjectCreation {
	public static void main(String[] args) {
		try {
			Class<?> cls = Student.class;
			Constructor<?> constructor = cls.getDeclaredConstructor(int.class, String.class);
			Student student = (Student)constructor.newInstance(1,"mohan");
			System.out.println("ID: " + student.id  + ",\nName: " + student.name);
			
			
		}catch(Exception e) {
			System.err.println("an error occured: " + e);
		}
	}
	

}
