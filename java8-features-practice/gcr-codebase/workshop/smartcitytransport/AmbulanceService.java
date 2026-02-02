package com.java8practice.workshop.smartcitytransport;

public class AmbulanceService implements TransportService, Emergency, GeoUtils, FareCalculator {
	@Override
	public void getServiceId() {
		System.out.println("Ambulance Service ID: AS123");
	}

	@Override
	public void getServiceName() {
		System.out.println("Ambulance Service Name: City Ambulance");
	}

	@Override
	public void getRoutes() {
		System.out.println("Ambulance Routes: Citywide");
	}

	@Override
	public void bookTrip(Passenger passenger, Route route) {
		System.out.println("Booking ambulance trip for " + passenger.getName() + " via route " + route.getRouteName());
	}

	@Override
	public double calculateFare(Route route) {
		return calculateDistance(route) * 5;
	}

	@Override
	public void startService() {
		System.out.println("Ambulance Service Started");
	}

	@Override
	public void stopService() {
		System.out.println("Ambulance Service Stopped");
	}

	public void respondToEmergency(String location) {
		System.out.println("Responding to emergency at " + location);
	}

	@Override
	public double calculateDistance(Route route) {
		return route.getDistance();
	}

}
