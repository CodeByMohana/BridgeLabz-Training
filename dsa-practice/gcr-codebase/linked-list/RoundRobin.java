package com.dsapractice.linkedlist;
//6. Circular Linked List: Round Robin Scheduling Algorithm

//Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list.

//Each node will represent a process and contain Process ID, Burst Time, and Priority.
//

class ProcessNode {
	int processId;
	int burstTime;
	int remainingTime;
	int priority;
	ProcessNode next;

	public ProcessNode(int processId, int burstTime, int priority) {
		this.processId = processId;
		this.burstTime = burstTime;
		this.remainingTime = burstTime;
		this.priority = priority;
		this.next = null;
	}

}
//Implement the following functionalities:
//Add a new process at the end of the circular list.
//Remove a process by Process ID after its execution.
//Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
//Display the list of processes in the circular queue after each round.
//Calculate and display the average waiting time and turn-around time for all processes.

interface ProcessManager {
	void addProcess(int processId, int burstTime, int priority);

	void removeProcess(ProcessNode prev, ProcessNode curr);

	void displayQueue();

	void simulate(int timeQuantum);
}

public class RoundRobin implements ProcessManager {

	private ProcessNode head = null;
	private int processCount = 0;
	private int totalProcesses = 0;

	@Override
	public void addProcess(int processId, int burstTime, int priority) {
		ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);

		if (head == null) {
			head = newProcess;
			newProcess.next = head;
		} else {
			ProcessNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newProcess;
			newProcess.next = head;
		}
		totalProcesses++;
		processCount++;

	}

	@Override
	public void removeProcess(ProcessNode prev, ProcessNode curr) {
		if (curr == head && curr.next == head) {
			head = null;
		} else if (curr == head) {
			ProcessNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			head = head.next;
			temp.next = head;
		} else {
			prev.next = curr.next;
		}
		processCount--;
	}

	@Override
	public void displayQueue() {
		if (head == null) {
			System.out.println("Queue is empty");
			return;
		}

		ProcessNode temp = head;
		do {
			System.out.print("[PID:" + temp.processId + ", RT:" + temp.remainingTime + "] -> ");
			temp = temp.next;
		} while (temp != head);
		System.out.println("(back to head)");
	}

	@Override
	public void simulate(int timeQuantum) {
		if (head == null) {
			System.out.println("No process available");
			return;
		}

		int currentTime = 0;
		int totalWaitingTime = 0;
		int totalTurnAroundTime = 0;

		ProcessNode curr = head;
		ProcessNode prev = null;

		while (processCount > 0) {
			displayQueue();

			if (curr.remainingTime > 0) {
				int execTime = Math.min(timeQuantum, curr.remainingTime);
				curr.remainingTime -= execTime;
				currentTime += execTime;

				if (curr.remainingTime == 0) {
					int turnAroundTime = currentTime;
					int waitingTime = turnAroundTime - curr.burstTime;

					totalTurnAroundTime += turnAroundTime;
					totalWaitingTime += waitingTime;

					System.out.println("Process " + curr.processId + " completed");

					ProcessNode nextNode = curr.next;
					removeProcess(prev, curr);
					curr = nextNode;
					continue;
				}
			}
			prev = curr;
			curr = curr.next;
		}
		System.out.println("\n===== FINAL RESULTS =====");
		System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
		System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / totalProcesses);
	}

	public static void main(String[] args) {

		RoundRobin scheduler = new RoundRobin();
		System.out.println("===== ADDING PROCESSES =====");
		scheduler.addProcess(1, 10, 2);
		scheduler.addProcess(2, 5, 1);
		scheduler.addProcess(3, 8, 3);
		scheduler.addProcess(4, 6, 2);

		int timeQuantum = 3;

		System.out.println("\n===== ROUND ROBIN SIMULATION =====");
		scheduler.simulate(timeQuantum);
	}

}
