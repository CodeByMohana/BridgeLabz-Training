package com.healthclinic.main;

import java.sql.Date;

import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Patient;

public class ClinicApp {
	public static void main(String[] args) {
		PatientDAO dao = new PatientDAO();

		Patient p = new Patient("Rahul Sharma", Date.valueOf("2004-12-04"), "9018725453", "Hyderabad", "B+");

		dao.registerPatient(p);
	}
}
