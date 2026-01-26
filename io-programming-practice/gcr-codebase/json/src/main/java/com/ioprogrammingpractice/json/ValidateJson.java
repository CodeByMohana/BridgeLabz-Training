package com.ioprogrammingpractice.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
	public static void main(String[] args) {
		String json = "{\"name\": \"Ravi\", \"age\": 22}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.readTree(json);
			System.out.println("Valid JSON");
		} catch (Exception e) {
			System.out.println("Invalid JSON");
		}
	}
}
