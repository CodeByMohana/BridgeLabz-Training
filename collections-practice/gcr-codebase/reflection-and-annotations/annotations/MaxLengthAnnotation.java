package com.collections.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
	int value();

}

class User {
	@MaxLength(10)
	private String userName;

	public User(String userName) {
		validate(userName);
		this.userName = userName;
	}

	private void validate(String userName) {
		try {
			Field field = this.getClass().getDeclaredField("userName");

			if (field.isAnnotationPresent(MaxLength.class)) {
				MaxLength maxLength = field.getAnnotation(MaxLength.class);
				int max = maxLength.value();

				if (userName != null && userName.length() > max) {
					throw new IllegalArgumentException("username length must not exceed " + max + " characters");

				}
			}
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}

	public String getUserName() {
		return userName;
	}

}

public class MaxLengthAnnotation {

	public static void main(String[] args) {
		try {
			User u1 = new User("Mohana Sai");
			System.out.println("User created: " + u1.getUserName());

			User u2 = new User("Tunuguntla Mohana Sai");
			System.out.println("User created: " + u2.getUserName());

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
