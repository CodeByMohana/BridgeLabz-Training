package com.java8practice.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
	private String title;
	private String genre;
	private int pages;

	public Book(String title, String genre, int pages) {
		this.title = title;
		this.genre = genre;
		this.pages = pages;
	}

	public String getGenre() {
		return genre;
	}

	public int getPages() {
		return pages;
	}
}

public class BookStatistics {
	public static void main(String[] args) {
		List<Book> books = List.of(new Book("Dune", "Sci-Fi", 500), new Book("Foundation", "Sci-Fi", 320),
				new Book("Hamlet", "Drama", 210), new Book("Macbeth", "Drama", 180),
				new Book("Clean Code", "Tech", 450));

		Map<String, IntSummaryStatistics> statsByGenre = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));

		statsByGenre.forEach((genre, stats) -> {
			System.out.println("Genre: " + genre);
			System.out.println("  Total pages: " + stats.getSum());
			System.out.println("  Average pages: " + stats.getAverage());
			System.out.println("  Max pages: " + stats.getMax());
			System.out.println();
		});
	}
}
