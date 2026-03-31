package com.java8practice.workshop.smartcitytransport;

public class BusService implements TransportService, GeoUtils, FareCalculator {

	private String serviceId;
	private String serviceName;

	public BusService(String serviceId, String serviceName) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
	}

	@Override
	public void getServiceId() {
		System.out.println("Bus Service ID: " + serviceId);
	}

	@Override
	public void getServiceName() {
		System.out.println("Bus Service Name: " + serviceName);
	}

	@Override
	public void getRoutes() {
		System.out.println("Bus Routes: Route A, Route B, Route C");
	}

	@Override
	public void bookTrip(Passenger passenger, Route route) {
		System.out.println("Booking trip for " + passenger.getName() + " on " + route.getRouteName());
	}

	@Override
	public double calculateFare(Route route) {
		return calculateDistance(route) * 2.0; // Example fare calculation
	}

	@Override
	public void startService() {
		System.out.println("Bus Service Started");
	}

	@Override
	public void stopService() {
		System.out.println("Bus Service Stopped");
	}

	@Override
	public double calculateDistance(Route route) {

		return route.getDistance();
	}

}
