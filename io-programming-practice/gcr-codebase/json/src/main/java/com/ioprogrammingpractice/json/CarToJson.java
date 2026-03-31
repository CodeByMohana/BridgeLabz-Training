package com.ioprogrammingpractice.json;

//import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
	private String make;
	private String model;
	private int year;

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

}

public class CarToJson {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
//		Car myCar = new Car("Honda", "Civic", 2022);
//		Class<?> cls = Car.class;
//		Field[] field = cls.getDeclaredFields();
//		
//		for (Field f : field) {
//			f.setAccessible(true);
//			Object value = f.get(myCar);
//			System.out.println(f.getName() + " = " + value);
//		}
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Car car = new Car("Toyota", "Camry", 2020);

			String jsonString = mapper.writeValueAsString(car);
			System.out.println(jsonString);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
