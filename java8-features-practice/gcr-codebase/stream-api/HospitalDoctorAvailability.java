package com.java8practice.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Doctor {
	private String name;
	private String speciality;
	private boolean weekendAvailable;

	public Doctor(String name, String speciality, boolean weekendAvailable) {
		this.name = name;
		this.speciality = speciality;
		this.weekendAvailable = weekendAvailable;
	}

	public String getName() {
		return name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public boolean isWeekendAvailable() {
		return weekendAvailable;
	}

	@Override
	public String toString() {
		return name + " - " + speciality;
	}

}

public class HospitalDoctorAvailability {
	public static void main(String[] args) {
		List<Doctor> doctors = List.of(new Doctor("Dr. Smith", "Cardiologist", true),
				new Doctor("Dr. Johnson", "Dermatologist", false), new Doctor("Dr. Williams", "Neurologist", true),
				new Doctor("Dr. Brown", "Pediatrician", false), new Doctor("Dr. Jones", "Orthopedic", true));

		List<Doctor> weekendDoctors = doctors.stream().filter(Doctor::isWeekendAvailable)
				.sorted(Comparator.comparing(Doctor::getSpeciality)).collect(Collectors.toList());
		
		weekendDoctors.forEach(System.out::println);
	}
}
