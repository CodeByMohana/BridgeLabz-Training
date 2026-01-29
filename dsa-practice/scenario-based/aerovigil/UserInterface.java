package com.scenariobased.dsa.aerovigil;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FlightUtil util = new FlightUtil();

		try {
			System.out.println("Enter Flight Details");
			String input = sc.nextLine();

			// Format:
			// FlightNumber:FlightName:PassengerCount:FuelLevel
			String[] parts = input.split(":");

			String flightNumber = parts[0];
			String flightName = parts[1];
			int passengerCapacity = Integer.parseInt(parts[2]);
			double currentFuelLevel = Double.parseDouble(parts[3]);

			// Validations
			util.validateFlightNumber(flightNumber);
			util.validateFlightName(flightName);
			util.validatePassengerCount(passengerCapacity, flightName);

			// Fuel Needed
			double fuelNeeded = util.calculateFuelToFillTank(flightName, currentFuelLevel);

			System.out.println("Fuel required to fill the tank: " + fuelNeeded + " liters");

		} catch (InvalidFlightException e) {

			System.out.println(e.getMessage());

		} catch (Exception e) {

			System.out.println("Invalid input format");
		}

		sc.close();
	}
}
