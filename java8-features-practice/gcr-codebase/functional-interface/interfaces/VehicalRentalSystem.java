package com.java8practice.functionalinterface.interfaces;

//○ Scenario: Cars, bikes, and buses share rent() and returnVehicle()
//methods.
//○ Task: Use interface-based design.

interface Rentable {
	void rent();

	void returnVehicle();

}

class Car implements Rentable {

	private boolean rented;

	@Override
	public void rent() {
		if (!rented) {
			rented = true;
			System.out.println("Car rented");
		}
	}

	@Override
	public void returnVehicle() {
		rented = false;
		System.out.println("Car returned");
	}

}

class Bike implements Rentable {

	private boolean rented;

	@Override
	public void rent() {
		if (!rented) {
			rented = true;
			System.out.println("Bike rented");
		}
	}

	@Override
	public void returnVehicle() {
		rented = false;
		System.out.println("Bike returned");
	}

}

class Bus implements Rentable {

	private boolean rented;

	@Override
	public void rent() {
		if (!rented) {
			rented = true;
			System.out.println("Bus rented");
		}
	}

	@Override
	public void returnVehicle() {
		rented = false;
		System.out.println("Bus returned");
	}

}

class RentableService {

	public void rentVehicle(Rentable vehicle) {
		vehicle.rent();

	}

	public void returnVehicle(Rentable vehicle) {
		vehicle.returnVehicle();
	}
}

public class VehicalRentalSystem {
	public static void main(String[] args) {
		RentableService service = new RentableService();
		
		Rentable car = new Car();
		Rentable bike = new Bike();
		Rentable bus = new Bus();
		
		service.rentVehicle(car);
		service.rentVehicle(bike);
		service.rentVehicle(bus);
		
		service.returnVehicle(bike);
	}
}
