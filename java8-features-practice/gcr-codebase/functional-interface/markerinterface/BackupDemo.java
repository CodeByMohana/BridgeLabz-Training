package com.java8practice.functionalinterface.markerinterface;

public class BackupDemo {

	interface BackupSerializable {
		// just a marker (no methods)
	}

	static class UserData implements BackupSerializable {
		private String name;
		private int age;

		public UserData(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "UserData{name='" + name + "', age=" + age + "}";
		}
	}

	static class Invoice implements BackupSerializable {
		private int invoiceId;

		public Invoice(int invoiceId) {
			this.invoiceId = invoiceId;
		}

		@Override
		public String toString() {
			return "Invoice{id=" + invoiceId + "}";
		}
	}

	// This will NOT be backed up
	static class Logs {
		private String message;

		public Logs(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Logs{message='" + message + "'}";
		}
	}

	static class BackupProcessor {

		public static void backup(Object obj) {

			if (obj instanceof BackupSerializable) {
				System.out.println("Backing up: " + obj);
			} else {
				System.out.println("Skipping (not serializable): " + obj);
			}
		}
	}

	public static void main(String[] args) {

		UserData user = new UserData("Alice", 25);
		Invoice invoice = new Invoice(101);
		Logs log = new Logs("System started");

		BackupProcessor.backup(user);
		BackupProcessor.backup(invoice);
		BackupProcessor.backup(log);
	}
}