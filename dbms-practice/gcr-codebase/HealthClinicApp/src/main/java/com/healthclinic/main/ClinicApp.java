package com.healthclinic.main;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import com.healthclinic.dao.*;
import com.healthclinic.model.*;

public class ClinicApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PatientDAO patientDAO = new PatientDAO();
		DoctorDAO doctorDAO = new DoctorDAO();
		AppointmentDAO appointmentDAO = new AppointmentDAO();

		while (true) {

			System.out.println("\n===== HEALTH CLINIC SYSTEM =====");
			System.out.println("1. Register Patient");
			System.out.println("2. Update Patient");
			System.out.println("3. Search Patient");
			System.out.println("4. View Patient Visit History");
			System.out.println("5. Add Doctor");
			System.out.println("6. Assign Specialty");
			System.out.println("7. View Doctors by Specialty");
			System.out.println("8. Deactivate Doctor");
			System.out.println("9. Book Appointment");
			System.out.println("10. Cancel Appointment");
			System.out.println("11. Reschedule Appointment");
			System.out.println("12. View Doctor Daily Schedule");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter name: ");
				String name = sc.nextLine();

				System.out.print("Enter DOB (yyyy-mm-dd): ");
				Date dob = Date.valueOf(sc.nextLine());

				System.out.print("Enter contact: ");
				String contact = sc.nextLine();

				System.out.print("Enter address: ");
				String address = sc.nextLine();

				System.out.print("Enter blood group: ");
				String blood = sc.nextLine();

				Patient patient = new Patient(name, dob, contact, address, blood);
				patientDAO.registerPatient(patient);
				break;

			case 2:
				System.out.print("Enter patient ID: ");
				int pid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new name: ");
				String newName = sc.nextLine();

				System.out.print("Enter DOB (yyyy-mm-dd): ");
				Date newDob = Date.valueOf(sc.nextLine());

				System.out.print("Enter contact: ");
				String newContact = sc.nextLine();

				System.out.print("Enter address: ");
				String newAddress = sc.nextLine();

				System.out.print("Enter blood group: ");
				String newBlood = sc.nextLine();

				Patient updated = new Patient(newName, newDob, newContact, newAddress, newBlood);
				patientDAO.updatePatient(pid, updated);
				break;

			case 3:
				System.out.print("Enter patient name to search: ");
				String searchName = sc.nextLine();
				patientDAO.searchPatientByName(searchName);
				break;

			case 4:
				System.out.print("Enter patient ID: ");
				int patientId = sc.nextInt();
				patientDAO.viewPatientVisitHistory(patientId);
				break;

			case 5:
				System.out.print("Enter doctor name: ");
				String dname = sc.nextLine();

				System.out.print("Enter specialty: ");
				String spec = sc.nextLine();

				System.out.print("Enter contact: ");
				String dcontact = sc.nextLine();

				Doctor doctor = new Doctor(dname, spec, dcontact, true);
				doctorDAO.addDoctor(doctor);
				break;

			case 6:
				System.out.print("Enter doctor ID: ");
				int docId = sc.nextInt();

				System.out.print("Enter specialty ID: ");
				int specId = sc.nextInt();

				doctorDAO.assignSpecialty(docId, specId);
				break;

			case 7:
				System.out.print("Enter specialty name: ");
				String specialty = sc.nextLine();
				doctorDAO.viewDoctorsBySpecialty(specialty);
				break;

			case 8:
				System.out.print("Enter doctor ID: ");
				int deactivateId = sc.nextInt();
				doctorDAO.deactivateDoctor(deactivateId);
				break;

			case 9:
				System.out.print("Enter patient ID: ");
				int apPatient = sc.nextInt();

				System.out.print("Enter doctor ID: ");
				int apDoctor = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter date (yyyy-mm-dd): ");
				Date apDate = Date.valueOf(sc.nextLine());

				System.out.print("Enter time (HH:mm:ss): ");
				Time apTime = Time.valueOf(sc.nextLine());

				Appointment appointment = new Appointment(apPatient, apDoctor, apDate, apTime);
				appointmentDAO.bookAppointment(appointment);
				break;

			case 10:
				System.out.print("Enter appointment ID: ");
				int cancelId = sc.nextInt();
				appointmentDAO.cancelAppointment(cancelId);
				break;

			case 11:
				System.out.print("Enter appointment ID: ");
				int resId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new date (yyyy-mm-dd): ");
				Date newDate = Date.valueOf(sc.nextLine());

				System.out.print("Enter new time (HH:mm:ss): ");
				Time newTime = Time.valueOf(sc.nextLine());

				appointmentDAO.rescheduleAppointment(resId, newDate, newTime);
				break;

			case 12:
				System.out.print("Enter doctor ID: ");
				int scheduleDoc = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter date (yyyy-mm-dd): ");
				Date scheduleDate = Date.valueOf(sc.nextLine());

				appointmentDAO.viewDailySchedule(scheduleDoc, scheduleDate);
				break;

			case 0:
				System.out.println("Exiting system...");
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}