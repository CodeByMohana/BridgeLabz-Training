package com.java8practice.streamapi;

import java.util.List;

public class EventsWelcomeMessage {
	public static void main(String[] args) {
        List<String> attendees = List.of("Alice", "Bob", "Charlie", "Diana");
        attendees.forEach(name -> System.out.println("Welcome to event " + name));
	}
}
