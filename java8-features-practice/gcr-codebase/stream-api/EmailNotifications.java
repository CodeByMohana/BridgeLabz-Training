package com.java8practice.streamapi;

import java.util.List;

public class EmailNotifications {
	public static void main(String[] args) {
		List<String> emails = List.of("alice@mail.com", "bob@mail.com", "charlie@mail.com");
		emails.forEach(EmailNotifications::sendEmailNotification);
	}

	private static void sendEmailNotification(String email) {
		System.out.println("Notification sent to: " + email);

	}
}
