package com.java8practice.functionalinterface.defaultmethod;

//○ Scenario: All vehicles have a method displaySpeed(), but electric vehicles
//also display battery percentage.
//○ Task: Use default methods to add this new feature.

interface Vehicle {

	void displaySpeed();

	default void displayBatteryPercentage() {
		System.out.println("Battery info not available for this vehicle.");
	}

}

class Car implements Vehicle {

	@Override
	public void displaySpeed() {
		System.out.println("Car speed is 120 km/h");
	}

}

class ElectricCar implements Vehicle {

	@Override
	public void displaySpeed() {
		System.out.println("Electric Car speed is 100 km/h");
	}

	@Override
	public void displayBatteryPercentage() {
		System.out.println("Electric Car battery at 80%");
	}

}

public class SmartVehicleDashboard {
	public static void main(String[] args) {
		Vehicle car = new Car();
		car.displaySpeed();
		car.displayBatteryPercentage();

		System.out.println();

		Vehicle electricCar = new ElectricCar();
		electricCar.displaySpeed();
		electricCar.displayBatteryPercentage();
	}

}
