package com.healthclinic.model;

import java.sql.Date;

public class Patient {
	private int patientId;
	private String name;
	private Date dob;
	private String contact;
	private String address;
	private String bloodGroup;

	public Patient(String name, Date dob, String contact, String address, String bloodGroup) {
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.address = address;
		this.bloodGroup = bloodGroup;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

	public String getContact() {
		return contact;
	}

	public String getAddress() {
		return address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}
}
