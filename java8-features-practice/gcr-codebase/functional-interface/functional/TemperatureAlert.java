package com.java8practice.functionalinterface.functional;

import java.util.function.Predicate;

class TemperatureAlertSystemForAC {
	public void checkTemperature(double temperature, Predicate<Double> alert) {
		if (alert.test(temperature)) {
			System.out.println("Hey AC! work at temp: " + temperature);
		} else {
			System.out.println("Temperature id normal: " + temperature + " so AC is in sleep mode");
		}
	}
}

public class TemperatureAlert {
	public static void main(String[] args) {
		
		TemperatureAlertSystemForAC service =new TemperatureAlertSystemForAC();
		
		Predicate<Double> highTemp = (t) -> t > 32;
		Predicate<Double> cold = (t) -> t < 16;
		Predicate<Double> alert = highTemp.or(cold);

		service.checkTemperature(35, alert);
		service.checkTemperature(24, alert);
		service.checkTemperature(10, alert);
	}
}
