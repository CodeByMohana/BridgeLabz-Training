package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.model.Doctor;
import com.healthclinic.util.DBConnection;

public class DoctorDAO {

	public void addDoctor(Doctor doctor) {

		String sql = "INSERT INTO doctors(name, specialty, contact, available) VALUES (?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getSpecialty());
			ps.setString(3, doctor.getContact());
			ps.setBoolean(4, doctor.isAvailable());

			ps.executeUpdate();

			System.out.println("Doctor added successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assignSpecialty(int doctorId, int specialtyId) {
		String sql = "INSERT INTO doctor_specialties (doctor_id, specialty_id) VALUES (?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, doctorId);
			ps.setInt(2, specialtyId);

			ps.executeUpdate();

			System.out.println("Specialty assigned successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewDoctorsBySpecialty(String specialty) {

		String sql = """
				SELECT d.doctor_id, d.name, d.contact, s.specialty_name
				FROM doctors d
				JOIN doctor_specialties ds ON d.doctor_id = ds.doctor_id
				JOIN specialties s ON ds.specialty_id = s.specialty_id
				WHERE s.specialty_name = ?
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, specialty);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("doctor_id");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				String spec = rs.getString("specialty_name");

				System.out.println("Doctor ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Contact: " + contact);
				System.out.println("Specialty: " + spec);
				System.out.println("------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateDoctor(int doctorId) {

		String sql = "UPDATE doctors SET available = false WHERE doctor_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Doctor deactivated successfully!");
			} else {
				System.out.println("Doctor not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void activateDoctor(int doctorId) {

		String sql = "UPDATE doctors SET available = true WHERE doctor_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Doctor activated successfully!");
			} else {
				System.out.println("Doctor not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
