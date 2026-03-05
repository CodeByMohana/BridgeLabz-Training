package com.healthclinic.main;

import java.sql.Date;

import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Doctor;
import com.healthclinic.model.Patient;

public class ClinicApp {
	public static void main(String[] args) {
		DoctorDAO dao = new DoctorDAO();
		
		dao.activateDoctor(1);
	}
}
