package com.java8practice.workshop.smartcitytransport;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SmartCity {
	public static void main(String[] args) {
		System.out.println("Welcome to Smart City Transport System");

		Passenger passenger = new Passenger("John Doe", "P12345");
		Passenger passenger2 = new Passenger("Jane", "P67890");
		Passenger passenger3 = new Passenger("Alice", "P54321");
		Route route = new Route("R001", "Downtown to Uptown", 15.0);
		Route route2 = new Route("R002", "Suburb to City Center", 25.0);
		Route route3 = new Route("R003", "Airport to Hotel", 30.0);

		Map<Passenger, Route> booking = new HashMap<>();
		booking.put(passenger, route2);
		booking.put(passenger2, route);
		booking.put(passenger3, route3);

		TransportService busService = new BusService("TS001", "City Bus Service");

		busService.startService();
		busService.displayServiceInfo();

		Comparator<Route> routeComparator = Comparator.comparingDouble(Route::getDistance);
		Comparator<TransportService> fare = Comparator.comparingDouble(s -> {
			if (s instanceof BusService) {
				return ((BusService) s).calculateFare(route);
			} else if (s instanceof AmbulanceService) {
				return ((AmbulanceService) s).calculateFare(route);
			}
			return Double.MAX_VALUE;
		});

	}
}
