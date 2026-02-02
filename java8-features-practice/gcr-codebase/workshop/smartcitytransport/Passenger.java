package com.java8practice.workshop.smartcitytransport;

public class Passenger {
	private String name;
	private String contactNumber;

	public Passenger(String name, String contactNumber) {
		this.name = name;
		this.contactNumber = contactNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

}
