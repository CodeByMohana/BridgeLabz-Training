package com.library.app;

import com.library.book.Book;
import com.library.catalog.LibraryCatalog;
import com.library.factory.UserFactory;
import com.library.user.User;

public class LibraryApp {

	public static void main(String[] args) {

		// ===== Singleton =====
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		// ===== Factory =====
		User student = UserFactory.createUser("student", "Sai");
		User faculty = UserFactory.createUser("faculty", "Dr Rao");

		// ===== Observer subscription =====
		catalog.addObserver(student);
		catalog.addObserver(faculty);

		// ===== Builder =====
		Book book1 = new Book.Builder("Data Structures").addAuthor("Cormen").edition("3rd").genre("Computer Science")
				.publisher("MIT Press").build();

		Book book2 = new Book.Builder("Operating Systems").addAuthor("Galvin").genre("Systems").build();

		// Add books (triggers notifications)
		catalog.addBook(book1);
		catalog.addBook(book2);

		catalog.showBooks();

		// Borrow rules
		student.borrow();
		faculty.borrow();
	}
}
