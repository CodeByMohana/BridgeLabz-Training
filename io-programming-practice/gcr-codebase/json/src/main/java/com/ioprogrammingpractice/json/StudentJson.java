package com.ioprogrammingpractice.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
	public static void main(String[] args) {
		JSONObject student = new JSONObject();
		student.put("name", "Mohan"); 
		student.put("age", 21);
		
		JSONArray subjects = new JSONArray();
		subjects.put("Mathematics");
		subjects.put("Physics");
		subjects.put("Chemistry");
		
		student.put("subjects", subjects);
		
		System.out.println(student.toString());
	}
}
