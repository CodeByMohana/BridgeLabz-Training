package com.scenariobased.dsa.aerovigil;

import java.util.HashMap;
import java.util.Map;

public class FlightUtil {

	private static final Map<String, Integer> PASSENGER_CAPACITY = new HashMap<String, Integer>();
	private static final Map<String, Double> FUEL_CAPACITY = new HashMap<String, Double>();

	static {
		PASSENGER_CAPACITY.put("spicejet", 396);
		PASSENGER_CAPACITY.put("vistara", 615);
		PASSENGER_CAPACITY.put("indigo", 230);
		PASSENGER_CAPACITY.put("air arabia", 130);

		FUEL_CAPACITY.put("spicejet", 200_000.0);
		FUEL_CAPACITY.put("vistara", 300_000.0);
		FUEL_CAPACITY.put("indigo", 250_000.0);
		FUEL_CAPACITY.put("air arabia", 150_000.0);

	}

	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
		if (flightNumber == null || !flightNumber.matches("FL-[1-9][0-9]{3}")) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
		}
		return true;

	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {
		if (!PASSENGER_CAPACITY.containsKey(flightName.toLowerCase())) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		return true;

	}

	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
		int maxCapacity = PASSENGER_CAPACITY.get(flightName.toLowerCase());

		if (passengerCount <= 0 || passengerCount > maxCapacity) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
		double maxCapacity = FUEL_CAPACITY.get(flightName.toLowerCase());

		if (currentFuelLevel < 0 || currentFuelLevel > maxCapacity) {
			throw new InvalidFlightException("Invalid fuel level for " + flightName);
		}

		return maxCapacity - currentFuelLevel;
	}
}
