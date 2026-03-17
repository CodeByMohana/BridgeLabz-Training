package com.scenariobased.m1.set3;

import java.util.*;

abstract class Festival {

	String name;
	String location;
	String date;

	Festival(String name, String location, String date) {
		this.name = name;
		this.location = location;
		this.date = date;
	}

	abstract void displayDetails();
}

// ---------------- MUSIC FESTIVAL ----------------

class MusicFestival extends Festival {

	String headliner;
	String musicGenre;
	int ticketPrice;

	public MusicFestival(String name, String location, String date, String headliner, String musicGenre,
			int ticketPrice) {
		super(name, location, date);
		this.headliner = headliner;
		this.musicGenre = musicGenre;
		this.ticketPrice = ticketPrice;
	}

	@Override
	void displayDetails() {

		System.out.println("Festival Name: " + this.name);
		System.out.println("Location: " + this.location);
		System.out.println("Date: " + this.date);
		System.out.println("Headliner: " + this.headliner);
		System.out.println("Music Genre: " + this.musicGenre);
		System.out.println("Ticket Price: " + this.ticketPrice);
	}
}

// ---------------- FOOD FESTIVAL ----------------

class FoodFestival extends Festival {

	String cuisine;
	int numStalls;
	int entryFee;

	public FoodFestival(String name, String location, String date, String cuisine, int numStalls, int entryFee) {
		super(name, location, date);
		this.cuisine = cuisine;
		this.numStalls = numStalls;
		this.entryFee = entryFee;
	}

	@Override
	void displayDetails() {

		System.out.println("Festival Name: " + this.name);
		System.out.println("Location: " + this.location);
		System.out.println("Date: " + this.date);
		System.out.println("Cuisine: " + this.cuisine);
		System.out.println("Number of Stalls: " + this.numStalls);
		System.out.println("Entry fee: " + this.entryFee);
	}
}

// ---------------- ART FESTIVAL ----------------

class ArtFestival extends Festival {

	String artType;
	int numArtists;
	int exhibitionFee;

	public ArtFestival(String name, String location, String date, String artType, int numArtists, int exhibitionFee) {
		super(name, location, date);
		this.artType = artType;
		this.numArtists = numArtists;
		this.exhibitionFee = exhibitionFee;
	}

	@Override
	void displayDetails() {
		System.out.println("Festival Name: " + this.name);
		System.out.println("Location: " + this.location);
		System.out.println("Date: " + this.date);
		System.out.println("Art Type: " + this.artType);
		System.out.println("Number of Artists: " + this.numArtists);
		System.out.println("Exhibition Fee: " + this.exhibitionFee);

	}

}

// ---------------- MAIN SYSTEM ----------------

public class EventPlannerFestivalManagementSystem {

	static Map<String, Festival> festivals = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String input = sc.nextLine();
			String[] parts = input.split(" ");

			String command = parts[0];

			switch (command) {

			case "ADD_FESTIVAL":
				addFestival(parts);
				break;

			case "DISPLAY_DETAILS":
				displayDetails(parts[1]);
				break;

			case "EXIT":
				sc.close();
				return;
			}
		}
	}

	// ---------------- ADD FESTIVAL ----------------

	static void addFestival(String[] parts) {

		String type = parts[1];

		if (type.equals("MUSIC")) {
			MusicFestival m = new MusicFestival(parts[2], parts[3], parts[4], parts[5], parts[6],
					Integer.parseInt(parts[7]));
			festivals.put(parts[2], m);
		} else if (type.equals("FOOD")) {
			FoodFestival f = new FoodFestival(parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]),
					Integer.parseInt(parts[7]));
			festivals.put(parts[2], f);
		} else if (type.equals("ART")) {
			ArtFestival a = new ArtFestival(parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]),
					Integer.parseInt(parts[7]));
			festivals.put(parts[2], a);
		}
	}

	// ---------------- DISPLAY ----------------

	static void displayDetails(String name) {

		// TODO fetch festival and display details
		festivals.get(name).displayDetails();

	}
}