package com.collections.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {

	String level() default "HIGH";

}

public class AnnotationTests {
	@ImportantMethod(level = "LOW")
	public void display() {
		System.out.println("Displayed");
	}

	@ImportantMethod
	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		Class<?> cls = AnnotationTests.class;

		System.out.println("Important Methods: ");

		for (Method method : cls.getDeclaredMethods()) {
			if (method.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
				System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
			}
		}
	}
}
