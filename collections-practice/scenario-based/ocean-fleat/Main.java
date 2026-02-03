package com.scenariobased.collections.oceanfleat;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VesselUtil util = new VesselUtil();

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			String[] data = input.split(":");

			String id = data[0];
			String name = data[1];
			double speed = Double.parseDouble(data[2]);
			String type = data[3];

			Vessel vessel = new Vessel(id, name, speed, type);

			util.addVesselPerformance(vessel);
		}

		String searchId = scanner.nextLine();
		Vessel found = util.getVesselById(searchId);

		if (found != null) {
			System.out.println(found.getVesselId() + " | " + found.getVesselName() + " | " + found.getVesselType()
					+ " | " + found.getAverageSpeed() + " knots");
		} else {
			System.out.println("Vessel Id " + searchId + " not found.");
		}

		List<Vessel> highList = util.getHighPerformanceVessels();

		highList.stream().forEach(v -> System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | "
				+ v.getVesselType() + " | " + v.getAverageSpeed() + " knots"));

		scanner.close();

	}
}
