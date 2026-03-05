package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.model.Patient;
import com.healthclinic.util.DBConnection;

public class PatientDAO {

	public void registerPatient(Patient patient) {

		String sql = "INSERT INTO patients(name, dob, contact, address, blood_group) VALUES (?, ?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, patient.getName());
			ps.setDate(2, patient.getDob());
			ps.setString(3, patient.getContact());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getBloodGroup());

			ps.executeUpdate();

			System.out.println("Patient registered successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePatient(int patientId, Patient patient) {

		String sql = "UPDATE patients SET name=?, dob=?, contact=?, address=?, blood_group=? WHERE patient_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, patient.getName());
			ps.setDate(2, patient.getDob());
			ps.setString(3, patient.getContact());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getBloodGroup());
			ps.setInt(6, patientId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Patient updated successfully");
			} else {
				System.out.println("Patient not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchPatientByName(String name) {

		String sql = "SELECT * FROM patients WHERE name LIKE ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, "%" + name + "%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("patient_id");
				String pname = rs.getString("name");
				String contact = rs.getString("contact");
				String address = rs.getString("address");
				String bloodGroup = rs.getString("blood_group");

				System.out.println("ID: " + id);
				System.out.println("Name: " + pname);
				System.out.println("Contact: " + contact);
				System.out.println("Address: " + address);
				System.out.println("Blood Group: " + bloodGroup);
				System.out.println("--------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewPatientVisitHistory(int patientID) {
		String sql = """
				SELECT p.name, v.visit_date, v.diagnosis, v.prescription
				FROM visits v
				JOIN patients p ON p.patient_id = v.patient_id
				WHERE p.patient_id = ?
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, patientID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				Date visitDate = rs.getDate("visit_date");
				String diagnosis = rs.getString("diagnosis");
				String prescription = rs.getString("prescription");

				System.out.println("Patient: " + name);
				System.out.println("Visit Date: " + visitDate);
				System.out.println("Diagnosis: " + diagnosis);
				System.out.println("Prescription: " + prescription);
				System.out.println("-----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
