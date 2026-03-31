package com.healthclinic.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

	private int patientId;
	private int doctorId;
	private Date appointmentDate;
	private Time appointmentTime;

	public Appointment(int patientId, int doctorId, Date appointmentDate, Time appointmentTime) {
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public Time getAppointmentTime() {
		return appointmentTime;
	}
}