package com.java8practice.lamdaexpression;

import java.util.List;
import java.util.function.Predicate;

class Alert {
	String message;
	String type;

	public Alert(String message, String type) {
		this.message = message;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + " : " + message;
	}
}

public class NotificationFiltering {
	public static void main(String[] args) {
		List<Alert> alerts = List.of(new Alert("Heart rate critical!", "CRITICAL"),
				new Alert("Time for medicine", "REMINDER"), new Alert("General checkup tomorrow", "INFO"),
				new Alert("Emergency in ICU", "EMERGENCY"));

		Predicate<Alert> filter = a -> a.type.equals("CRITICAL") || a.type.equals("EMERGENCY");
		alerts.stream().filter(filter).forEach(System.out::println);
	}
}
