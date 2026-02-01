package com.scenariobased.dsa.robot;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RobotHazardAuditor auditor = new RobotHazardAuditor();

		try {
			System.out.println("Enter Arm Precision (0.0 - 1.0): ");
			double armPrecision = sc.nextDouble();

			System.out.println("Enter Worker Density (1 - 20): ");
			int workerDensity = sc.nextInt();
			sc.nextLine(); // because we have \n in Input Buffer 
			
			System.out.println("Enter Machinery State (Worn/Faulty/Critical): ");
			String machineryState = sc.nextLine();

			double risk = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);

			System.out.println("Robot Hazard Risk: " + risk);

		} catch (RobotSafetyException e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}
}
