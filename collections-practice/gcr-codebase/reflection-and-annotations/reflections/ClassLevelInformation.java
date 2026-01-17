package com.collections.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassLevelInformation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter fully qualified class name: ");
		String className = sc.nextLine();
		
		try {
			Class<?> cls = Class.forName(className);
			System.out.println("\n ---- Class Name ---- ");
			System.out.println(cls.getName());
			
			//Constructors
			System.out.println("\n ---- Constructors ---- ");
			Constructor<?>[] constructors = cls.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}
			
			//Fields
			System.out.println("\n ---- Fields ---- ");
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(
	                    Modifier.toString(field.getModifiers()) + " " +
	                    field.getType().getSimpleName() + " " +
	                    field.getName()
	                );
			}
			
			//Methods
			System.out.println("\n ---- Methods ---- ");
			Method[] methods = cls.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(
						Modifier.toString(method.getModifiers()) + " " +
			                    method.getReturnType().getSimpleName() + " " +
			                    method.getName()
						);
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found. Please check the name");
		}
	}
}
