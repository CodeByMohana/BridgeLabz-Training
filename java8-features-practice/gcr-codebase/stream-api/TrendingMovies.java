package com.java8practice.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Movie {
	private String name;
	private double rating;
	private int year;

	public Movie(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " | Rating: " + rating + " | Year: " + year;
	}

}

public class TrendingMovies {
	public static void main(String[] args) {
		List<Movie> movies = Arrays.asList(new Movie("Inception", 8.8, 2010), new Movie("Interstellar", 8.6, 2014),
				new Movie("Jawan", 7.2, 2023), new Movie("RRR", 8.0, 2022), new Movie("Oppenheimer", 9.0, 2023),
				new Movie("Avatar 2", 7.8, 2022), new Movie("Dune 2", 8.9, 2024), new Movie("Tenet", 7.5, 2020));
		
		List<Movie> top5 = movies.stream().filter(movie -> movie.getYear() >= 2020)
				.sorted(Comparator
						.comparing(Movie::getRating).reversed()
						.thenComparing(Movie::getYear).reversed()).limit(5).toList();
		
		top5.forEach(System.out::println);
				
	}

}
