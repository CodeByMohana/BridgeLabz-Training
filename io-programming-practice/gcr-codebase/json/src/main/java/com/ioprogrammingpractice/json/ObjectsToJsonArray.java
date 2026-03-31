package com.ioprogrammingpractice.json;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class User {
	public String name;
	public int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class ObjectsToJsonArray {
	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User("Anil", 25), new User("Sunil", 28));

		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonArray = mapper.writeValueAsString(users);
			System.out.println(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
