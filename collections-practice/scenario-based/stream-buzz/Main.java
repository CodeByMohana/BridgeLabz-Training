package com.scenariobased.collections.streambuzz;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Program program = new Program();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to StreamBuzz");

		while (true) {

			System.out.println("\n1. Register Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");

			System.out.print("Enter your choice:");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				sc.nextLine(); // clear buffer

				System.out.print("Enter Creator Name: ");
				String name = sc.nextLine();

				double[] likes = new double[4];

				System.out.println("Enter weekly likes (Week 1 to 4):");

				for (int i = 0; i < 4; i++) {
					likes[i] = sc.nextDouble();
				}

				CreatorStats record = new CreatorStats(name, likes);
				program.RegisterCreator(record);

				System.out.println("Creator registered successfully");
				break;

			case 2:

				System.out.println("Enter like threshold:");
				double threshold = sc.nextDouble();

				Map<String, Integer> result = program.getTopPostCounts(CreatorStats.engagementBoard, threshold);

				if (result.isEmpty()) {
					System.out.println("No top-performing posts this week");
				} else {

					for (Map.Entry<String, Integer> entry : result.entrySet()) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
					}
				}

				break;

			case 3:

				double avg = program.CalculateAverageLikes();
				System.out.println("Overall average weekly likes: " + avg);
				break;

			case 4:
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice");
			}
		}

	}
}
