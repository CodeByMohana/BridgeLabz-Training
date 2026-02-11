package com.java8practice.streamapi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Member {
	private String name;
	private LocalDate expiryDate;

	public Member(String name, LocalDate expiryDate) {
		this.name = name;
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return name;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	@Override
	public String toString() {
		return name + " -> " + expiryDate;
	}
}

public class FilteringExpiringMemberships {
	public static void main(String[] args) {
		List<Member> members = Arrays.asList(new Member("Ravi", LocalDate.now().plusDays(10)),
				new Member("Anita", LocalDate.now().plusDays(40)), new Member("Kiran", LocalDate.now().plusDays(25)),
				new Member("Sneha", LocalDate.now().plusDays(5)));

		LocalDate today = LocalDate.now();
		LocalDate limit = today.plusDays(30);

		List<Member> expiringSoon = members.stream()
				.filter(m -> !m.getExpiryDate().isBefore(today) && !m.getExpiryDate().isAfter(limit))
				.collect(Collectors.toList());

		expiringSoon.forEach(System.out::println);
	}

}
