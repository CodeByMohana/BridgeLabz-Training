package com.multithreading;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class TaskRunner extends Thread {

	public TaskRunner(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000); // TIMED_WAITING

			for (int i = 0; i < 1_000_000; i++) {
				Math.sqrt(i); // RUNNABLE
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class StateMonitor extends Thread {

	private Thread[] tasks;

	public StateMonitor(Thread... tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run() {

		Map<String, Integer> count = new HashMap<>();

		boolean running = true;

		while (running) {

			running = false;

			for (Thread t : tasks) {

				Thread.State state = t.getState();

				System.out.println("[Monitor] " + t.getName() + " is in " + state + " at " + LocalTime.now());

				count.put(t.getName(), count.getOrDefault(t.getName(), 0) + 1);

				if (state != Thread.State.TERMINATED)
					running = true;
			}

			try {
				Thread.sleep(500);
			} catch (Exception ignored) {
			}
		}

		count.forEach((k, v) -> System.out.println("Summary: " + k + " observed " + v + " times"));
	}
}
