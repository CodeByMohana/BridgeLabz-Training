package com.java8practice.streamapi;

import java.util.List;

public class IoTSensorReadings {
	public static void main(String[] args) {
		List<Double> readings = List.of(23.5, 45.2, 67.8, 12.4, 88.9);
		double threshold = 50.0;
		readings.stream().filter(r -> r > threshold).forEach(r -> System.out.println("High reading detected: " + r));
	}

}
