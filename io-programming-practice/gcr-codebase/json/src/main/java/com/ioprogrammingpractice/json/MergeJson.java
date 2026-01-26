package com.ioprogrammingpractice.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			ObjectNode json1 = (ObjectNode) mapper.readTree("{\"name\":\"Sumith\",\"age\":20}");
			ObjectNode json2 = (ObjectNode) mapper.readTree("{\"city\":\"Mathura\",\"age\":30}");

			json1.setAll(json2); // merge

			System.out.println(json1.toPrettyString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
