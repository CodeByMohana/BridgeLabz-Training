package com.oop.gcrcodebase.inheritance;

class Book {
	String title;
	int publishedYear;

	public Book(String title, int publishedYear) {
		this.title = title;
		this.publishedYear = publishedYear;
	}

}

class Author extends Book {
	String name;
	String bio;

	public Author(String title, int publishedYear, String name, String bio) {
		super(title, publishedYear);
		this.name = name;
		this.bio = bio;
	}

	public void displayInfo() {
		System.out.println("Book Title: " + title);
		System.out.println("Publication Year: " + publishedYear);
		System.out.println("Author Name: " + name);
		System.out.println("Author Bio: " + bio);
	}
}

public class LibraryManagement {
	public static void main(String[] args) {
		Author author = new Author("The Silent Observer", 2022, "Aarav Mehta",
				"Aarav is an Indian novelist known for contemporary fiction and short stories.");

		author.displayInfo();
	}
}
