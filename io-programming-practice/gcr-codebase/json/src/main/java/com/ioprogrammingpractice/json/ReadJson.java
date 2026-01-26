package com.ioprogrammingpractice.json;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jsonNode = mapper.readTree(new File("src/main/resources/user.json"));

			String name = jsonNode.get("name").asText();
			String email = jsonNode.get("email").asText();

			System.out.println("Name: " + name);
			System.out.println("Email: " + email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
