package com.oop.gcrcodebase.thisstaticinstanceof;

public class Book {
	static String libraryName = "City Library";

	private String title;
	private String author;
	private final String isbn;

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public static void displayLibraryName() {
		System.out.println("Library Name: " + libraryName);
	}

	public void displayBookDetails() {
		if (this instanceof Book) {
			System.out.println("Title: " + title);
			System.out.println("Author: " + author);
			System.out.println("ISBN: " + isbn);
			System.out.println("------------------------------");
		} else {
			System.out.println("Invalid book object.");
		}
	}

	public static void main(String[] args) {
		Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "ISBN12345");
		Book b2 = new Book("1984", "George Orwell", "ISBN67890");

		Book.displayLibraryName();
		b1.displayBookDetails();
		b2.displayBookDetails();
	}

}
