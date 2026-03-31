package com.ioprogrammingpractice.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;




public class JsonFilter {
	 public static void main(String[] args) throws Exception {

	        String json = "[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\",\"age\":30},{\"name\":\"Charlie\",\"age\":35}]";

	        ObjectMapper mapper = new ObjectMapper();
	        ArrayNode users = (ArrayNode) mapper.readTree(json);

	        ArrayNode result = mapper.createArrayNode();

	        for (JsonNode user : users) {
	            if (user.get("age").asInt() > 25) {
	                result.add(user);
	            }
	        }

	        System.out.println(result.toPrettyString());
	    }
}
