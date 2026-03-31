package com.collections.reflections;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
	String name();
}

@Author(name = "Mohana Sai")
class SampleClass {
	void show() {
		System.out.println("Sample class");
	}
}

public class RetrieveAnnotationsAtRuntime {
	public static void main(String[] args) {
		Class<?> cls = SampleClass.class;

		if (cls.isAnnotationPresent(Author.class)) {
			Author author = cls.getAnnotation(Author.class);

			System.out.println("Author name: " + author.name());
		} else {
			System.out.println("Author annotation not present");
		}
	}

}
