package com.java8practice.functionalinterface.staticinterface;

interface UnitConverter {
	double KM_TO_MILES = 0.621371;
	double KG_TO_LBS = 2.20462;

	// distance
	static double kmToMiles(double km) {
		return km * KM_TO_MILES;
	}

	static double milesToKm(double miles) {
		return miles / KM_TO_MILES;
	}

	// weight
	static double kgToLbs(double kg) {
		return kg * KG_TO_LBS;
	}

	static double lbsToKg(double lbs) {
		return lbs / KG_TO_LBS;
	}
}

public class UnitConversionTool {
	public static void main(String[] args) {
		double miles = UnitConverter.kmToMiles(10);
		double kg = UnitConverter.lbsToKg(100);

		System.out.println("10 km -> " + miles + " miles");
		System.out.println("100 lbs -> " + kg + " kg");
	}

}
