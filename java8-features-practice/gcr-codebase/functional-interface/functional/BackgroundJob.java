package com.java8practice.functionalinterface.functional;

public class BackgroundJob {
	public static void main(String[] args) {
		Runnable job = () -> {
			System.out.println("Job started....");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Job Finished");
		};

		Thread thread = new Thread(job); // Thread can take a runnable tasks

		thread.start(); // async

		System.out.println("Main thread continues....");
	}
}
