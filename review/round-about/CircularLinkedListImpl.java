package com.reviewquestions.roundabout;

import java.util.LinkedList;
import java.util.Scanner;

public class CircularLinkedListImpl implements CircularLinkedList {

	private Node head;
	int size = 0;
	int count = 0;

	Scanner sc = new Scanner(System.in);
	LinkedList<String> queue = new LinkedList<>();

	public void start() {
		System.out.print("Enter the size: ");
		size = sc.nextInt();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the vehicle number: ");
			String vehicleNumber = sc.next();
			queue.addLast(vehicleNumber);
			add();
		}
	}

	@Override
	public void waiting() {
		System.out.print("Enter the vehicle number: ");
		String vehicleNumber = sc.next();
		queue.addLast(vehicleNumber);
		add();
	}

	@Override
	public void add() {
		if (count == size || queue.isEmpty()) {
			System.out.println("Vehicle is added in the queue ");
			return;
		}

		String vehicleNumber = queue.removeFirst();
		Node newVehicle = new Node(vehicleNumber);

		if (head == null) {
			head = newVehicle;
			newVehicle.next = head;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newVehicle;
			newVehicle.next = head;
		}

		count++;
		System.out.println("Vehicle added successfully: " + vehicleNumber);
	}

	@Override
	public void remove() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		System.out.print("Enter the vehicle number to remove: ");
		String vehicleNumber = sc.next();

		Node curr = head;
		Node prev = null;

		do {
			if (curr.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {

				if (curr == head && curr.next == head) {
					head = null;
				} else if (curr == head) {
					Node temp = head;
					while (temp.next != head) {
						temp = temp.next;
					}
					head = head.next;
					temp.next = head;
				} else {
					prev.next = curr.next;
				}

				count--;
				System.out.println("Vehicle removed: " + vehicleNumber);

				add();
				return;
			}

			prev = curr;
			curr = curr.next;

		} while (curr != head);

		System.out.println("Vehicle not found");
	}

	@Override
	public void display() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node temp = head;
		do {
			System.out.print(temp.vehicleNumber + " -> ");
			temp = temp.next;
		} while (temp != head);

		System.out.println("(back to start)");
	}
}
