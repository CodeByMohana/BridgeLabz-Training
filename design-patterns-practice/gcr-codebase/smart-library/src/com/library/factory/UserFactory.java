package com.library.factory;

import com.library.user.Faculty;
import com.library.user.Librarian;
import com.library.user.Student;
import com.library.user.User;

public class UserFactory {
	public static User createUser(String role, String name) {
		switch (role.toLowerCase()) {
		case "student":
			return new Student(name);

		case "faculty":
			return new Faculty(name);

		case "librarian":
			return new Librarian(name);

		default:
			throw new IllegalArgumentException("Invalid role: " + role);
		}
	}
}
