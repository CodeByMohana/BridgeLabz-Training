package com.scenariobased.m1.set1;

import java.util.*;

public class VersionControlledStorageSystem {

	static class Version {
		String version;
		int size;

		Version(String version, int size) {
			this.version = version;
			this.size = size;
		}
	}

	// FileName -> List of Versions
	static Map<String, List<Version>> storage = new HashMap<>();

	// FileName -> Latest Version
	static Map<String, Version> latestVersion = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			String input = sc.nextLine();
			String[] parts = input.split(" ");

			String operation = parts[0];

			switch (operation) {

			case "UPLOAD":
				upload(parts[1], parts[2], Integer.parseInt(parts[3]));
				break;

			case "FETCH":
				fetch(parts[1]);
				break;

			case "LATEST":
				latest(parts[1]);
				break;

			case "TOTAL_STORAGE":
				totalStorage(parts[1]);
				break;
			}
		}

		sc.close();
	}

	// ---------------- OPERATIONS ----------------

	static void upload(String fileName, String version, int size) {

		storage.putIfAbsent(fileName, new ArrayList<>());

		List<Version> versions = storage.get(fileName);
		for (Version v : versions) {
			if (v.version.equals(version)) {
				return;
			}
		}
		Version newVersion = new Version(version, size);
		versions.add(newVersion);

		latestVersion.put(fileName, newVersion);

	}

	static void fetch(String fileName) {

		if (!storage.containsKey(fileName)) {
			System.out.println("File Not Found");
			return;
		}

		List<Version> versions = storage.get(fileName);

		versions.sort((a, b) -> {
			if (a.size != b.size)
				return a.size - b.size;
			return a.version.compareTo(b.version);
		});

		for (Version v : versions) {
			System.out.println(fileName + " " + v.version + " " + v.size);
		}
	}

	static void latest(String fileName) {
		if (!latestVersion.containsKey(fileName)) {
			System.out.println("File Not Found");
			return;
		}

		Version v = latestVersion.get(fileName);

		System.out.println(fileName + " " + v.version + " " + v.size);
	}

	static void totalStorage(String fileName) {

		if (!storage.containsKey(fileName)) {
			System.out.println("File Not Found");
			return;
		}

		int total = 0;

		for (Version v : storage.get(fileName)) {
			total += v.size;
		}

		System.out.println(fileName + " " + total);
	}

}