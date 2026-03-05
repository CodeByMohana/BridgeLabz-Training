package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import com.healthclinic.model.Appointment;
import com.healthclinic.util.DBConnection;

public class AppointmentDAO {

	public void bookAppointment(Appointment appointment) {

		if (!isDoctorAvailable(appointment.getDoctorId(), appointment.getAppointmentDate(),
				appointment.getAppointmentTime())) {

			System.out.println("Doctor not available at this time.");
			return;
		}

		String sql = """
				INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time)
				VALUES (?, ?, ?, ?)
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, appointment.getPatientId());
			ps.setInt(2, appointment.getDoctorId());
			ps.setDate(3, appointment.getAppointmentDate());
			ps.setTime(4, appointment.getAppointmentTime());

			ps.executeUpdate();

			System.out.println("Appointment booked successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isDoctorAvailable(int doctorId, Date date, Time time) {

		String sql = """
				SELECT COUNT(*)
				FROM appointments
				WHERE doctor_id = ?
				AND appointment_date = ?
				AND appointment_time = ?
				AND status = 'SCHEDULED'
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);
			ps.setDate(2, date);
			ps.setTime(3, time);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count == 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void cancelAppointment(int appointmentId) {

		String sql = "UPDATE appointments SET status = 'CANCELLED' WHERE appointment_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, appointmentId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Appointment cancelled successfully.");
			} else {
				System.out.println("Appointment not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rescheduleAppointment(int appointmentId, Date newDate, Time newTime) {

		String sql = """
				UPDATE appointments
				SET appointment_date = ?, appointment_time = ?
				WHERE appointment_id = ?
				AND status = 'SCHEDULED'
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setDate(1, newDate);
			ps.setTime(2, newTime);
			ps.setInt(3, appointmentId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Appointment rescheduled successfully.");
			} else {
				System.out.println("Appointment not found or already cancelled.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewDailySchedule(int doctorId, Date date) {

		String sql = """
				SELECT a.appointment_id, p.name, a.appointment_time
				FROM appointments a
				JOIN patients p ON a.patient_id = p.patient_id
				WHERE a.doctor_id = ?
				AND a.appointment_date = ?
				AND a.status = 'SCHEDULED'
				ORDER BY a.appointment_time
				""";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);
			ps.setDate(2, date);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("appointment_id");
				String patientName = rs.getString("name");
				Time time = rs.getTime("appointment_time");

				System.out.println("Appointment ID: " + id);
				System.out.println("Patient: " + patientName);
				System.out.println("Time: " + time);
				System.out.println("----------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}