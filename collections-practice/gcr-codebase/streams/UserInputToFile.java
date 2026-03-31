package com.collections.streams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter name: ");
			String name = br.readLine();

			System.out.print("Enter age: ");
			String age = br.readLine();

			System.out.print("Enter favorite programming language: ");
			String language = br.readLine();

			FileWriter fw = new FileWriter("userDetails.txt");
			fw.write("Name: " + name + "\n");
			fw.write("Age: " + age + "\n");
			fw.write("Favorite Language: " + language);

			fw.close();

			System.out.println("User data saved successfully");

		} catch (IOException e) {
			System.out.println("Error occurred");
		}
	}
}
