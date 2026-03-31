package com.library.catalog;

import java.util.ArrayList;
import java.util.List;

import com.library.book.Book;
import com.library.observer.Observer;
import com.library.observer.Subject;

public class LibraryCatalog implements Subject {
	// ===== Singleton =====
	private static LibraryCatalog instance;

	private List<Book> books = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	private LibraryCatalog() {
	}

	public static synchronized LibraryCatalog getInstance() {
		if (instance == null) {
			instance = new LibraryCatalog();
		}
		return instance;
	}

	// ==== Catalog functions ====

	public void addBook(Book book) {
		books.add(book);
		notifyObservers("Book available: " + book.getTitle());
	}

	public void showBooks() {
		System.out.println("\n===== Library Books =====");
		books.forEach(System.out::println);
	}

	// ===== Observer methods =====

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(String message) {
		observers.stream().forEach(o -> o.update(message));
	}

}
