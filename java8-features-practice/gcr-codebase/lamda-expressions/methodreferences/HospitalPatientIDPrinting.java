package com.java8practice.methodreferences;

import java.util.Arrays;
import java.util.List;

class Patient {
	String id;

	public Patient(String id) {
		this.id = id;
	}

	public void printId() {
		System.out.println(id);
	}
}

public class HospitalPatientIDPrinting {
	public static void main(String[] args) {

		List<Patient> patients = Arrays.asList(new Patient("P101"), new Patient("P102"), new Patient("P103"));
		
		patients.forEach(Patient::printId);
	}
}
