package com.java8practice.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
	private String claimType;
	private double amount;

	public Claim(String claimType, double amount) {
		this.claimType = claimType;
		this.amount = amount;
	}

	public String getClaimType() {
		return claimType;
	}

	public double getAmount() {
		return amount;
	}

}

public class InsuranceClaimAnalysis {
	public static void main(String[] args) {
		List<Claim> claims = Arrays.asList(new Claim("Health", 5000), new Claim("Vehicle", 12000),
				new Claim("Health", 7000), new Claim("Vehicle", 8000), new Claim("Home", 15000),
				new Claim("Health", 6000));

		Map<String, Double> avgByType = claims.stream()
				.collect(Collectors.groupingBy(Claim::getClaimType, Collectors.averagingDouble(Claim::getAmount)));
		
		avgByType.forEach((type, avg) -> System.out.println(type + " -> " + avg));
	}
}
