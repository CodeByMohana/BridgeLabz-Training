package com.reviewquestions.roundabout;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		CircularLinkedListImpl roundabout = new CircularLinkedListImpl();
		Scanner sc = new Scanner(System.in);

		roundabout.start(); // initial vehicles

		while (true) {
			System.out.println("\n---- ROUNDABOUT MENU ----");
			System.out.println("1. Add vehicle (waiting)");
			System.out.println("2. Remove vehicle");
			System.out.println("3. Display roundabout");
			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				roundabout.waiting();
				break;

			case 2:
				roundabout.remove();
				break;

			case 3:
				roundabout.display();
				break;

			case 4:
				System.out.println("Exiting program...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
