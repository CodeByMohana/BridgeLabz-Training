package com.java8practice.workshop.smartcitytransport;

public interface TransportService {
	void getServiceId();

	void getServiceName();

	void getRoutes();

	void bookTrip(Passenger passenger, Route route);
	
	void startService();

	void stopService();

	default void displayServiceInfo() {
		System.out.println("Transport Service Information");
	}

}
