package com.healthclinic.model;

public class Doctor {
	private String name;
	private String specialty;
	private String contact;
	private boolean available;

	public Doctor(String name, String specialty, String contact, boolean available) {
		this.name = name;
		this.specialty = specialty;
		this.contact = contact;
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public String getContact() {
		return contact;
	}

	public boolean isAvailable() {
		return available;
	}

}
