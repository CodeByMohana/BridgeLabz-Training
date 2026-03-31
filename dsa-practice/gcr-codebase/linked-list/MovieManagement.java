package com.dsapractice.linkedlist;

class MovieNode {
	String title;
	String director;
	int year;
	double rating;
	MovieNode next;
	MovieNode previous;

	public MovieNode(String title, String director, int year, double rating) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
		this.next = null;
		this.previous = null;
	}

}

interface MovieManaging {
	// Add Movie at beginning
	void addMovieAtBeginning(String title, String director, int year, double rating);

	// Add Movie at ending
	void addMovieAtEnd(String title, String director, int year, double rating);

	// Add Movie at any position
	void addMovie(int position, String title, String director, int year, double rating);

	// Remove Move Record
	void removeMovie(String title);

	// Display all movie records
	void displayRecords();

	// Update rating
	void updateRating(String title, double rating);
}

public class MovieManagement implements MovieManaging {
	private MovieNode head;
	private MovieNode tail;

	@Override
	public void addMovieAtBeginning(String title, String director, int year, double rating) {
		MovieNode newMovie = new MovieNode(title, director, year, rating);
		if (head == null) {
			head = newMovie;
			tail = newMovie;
			return;
		}
		newMovie.next = head;
		head.previous = newMovie;
		head = newMovie;

	}

	@Override
	public void addMovieAtEnd(String title, String director, int year, double rating) {
		if (head == null) {
			addMovieAtBeginning(title, director, year, rating);
			return;
		}
		MovieNode newMovie = new MovieNode(title, director, year, rating);
		tail.next = newMovie;
		newMovie.previous = tail;
		tail = newMovie;

	}

	@Override
	public void addMovie(int position, String title, String director, int year, double rating) {
		if (position <= 1 || head == null) {
			addMovieAtBeginning(title, director, year, rating);
			return;
		}
		MovieNode newMovie = new MovieNode(title, director, year, rating);
		MovieNode temp = head;
		int count = 1;
		while (count < position - 1 && temp != null) {
			count++;
			temp = temp.next;
		}
		if (temp.next == null) {
			addMovieAtEnd(title, director, year, rating);
			return;
		}
		newMovie.next = temp.next;
		newMovie.previous = temp;
		temp.next.previous = newMovie;
		temp.next = newMovie;
	}

	@Override
	public void removeMovie(String title) {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		MovieNode temp = head;

		while (temp != null && !temp.title.equalsIgnoreCase(title)) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Movie not found");
			return;
		}

		if (temp == head) {
			head = head.next;
			if (head != null) {
				head.previous = null;
			} else {
				tail = null;
			}
			return;
		}

		if (temp == tail) {
			tail = tail.previous;
			tail.next = null;
			return;
		}

		temp.previous.next = temp.next;
		temp.next.previous = temp.previous;

	}

	@Override
	public void displayRecords() {
		if (head == null) {
			System.out.println("No movie records found");
			return;
		}

		MovieNode temp = head;
		while (temp != null) {
			System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year
					+ ", Rating: " + temp.rating);
			temp = temp.next;
		}
	}

	@Override
	public void updateRating(String title, double rating) {
		MovieNode temp = head;

		while (temp != null) {
			if (temp.title.equals(title)) {
				temp.rating = rating;
				return;
			}
			temp = temp.next;
		}

		System.out.println("Movie not found");
	}

	public static void main(String[] args) {
		MovieManagement mm = new MovieManagement();

		System.out.println("=== Adding movies at beginning ===");
		mm.addMovieAtBeginning("Inception", "Nolan", 2010, 9.0);
		mm.addMovieAtBeginning("The Matrix", "Wachowski", 1999, 8.7);
		mm.displayRecords();

		System.out.println("\n=== Adding movies at end ===");
		mm.addMovieAtEnd("Interstellar", "Nolan", 2014, 8.8);
		mm.addMovieAtEnd("Dune", "Villeneuve", 2021, 8.5);
		mm.displayRecords();

		System.out.println("\n=== Adding movie at position 3 ===");
		mm.addMovie(3, "Avatar", "Cameron", 2009, 7.8);
		mm.displayRecords();

		System.out.println("\n=== Updating rating ===");
		mm.updateRating("Avatar", 8.2);
		mm.updateRating("NonExistentMovie", 7.0); // Test movie not found
		mm.displayRecords();

		System.out.println("\n=== Removing head movie ===");
		mm.removeMovie("The Matrix"); // Head
		mm.displayRecords();

		System.out.println("\n=== Removing tail movie ===");
		mm.removeMovie("Dune"); // Tail
		mm.displayRecords();

		System.out.println("\n=== Removing middle movie ===");
		mm.removeMovie("Interstellar"); // Middle
		mm.displayRecords();

		System.out.println("\n=== Removing non-existent movie ===");
		mm.removeMovie("NonExistentMovie"); // Should print "Movie not found"
		mm.displayRecords();

		System.out.println("\n=== Adding more movies ===");
		mm.addMovieAtEnd("Tenet", "Nolan", 2020, 7.5);
		mm.addMovieAtBeginning("The Dark Knight", "Nolan", 2008, 9.0);
		mm.displayRecords();
	}

}
