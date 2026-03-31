package com.dsapractice.linkedlist;

class TaskNode {
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	TaskNode next;

	public TaskNode(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
		this.next = null;
	}

}

interface TaskOperations {
	void addAtBeginning(int taskId, String taskName, int priority, String dueDate);

	void addAtEnd(int taskId, String taskName, int priority, String dueDate);

	void addAtPostion(int position, int taskId, String taskName, int priority, String dueDate);

	void removeById(int id);

	void viewCurrentTask();

	void displayTasks();

	void searchByPriority(int priority);
}

public class TaskScheduler implements TaskOperations {
	private TaskNode head = null;
	private TaskNode current = null;

	@Override
	public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
		TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
		if (head == null) {
			head = newTask;
			newTask.next = head;
		} else {
			TaskNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			newTask.next = head;
			temp.next = newTask;
			head = newTask;
		}
	}

	@Override
	public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
		if (head == null) {
			addAtBeginning(taskId, taskName, priority, dueDate);
			return;
		}
		TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
		TaskNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = newTask;
		newTask.next = head;
	}

	@Override
	public void addAtPostion(int position, int taskId, String taskName, int priority, String dueDate) {
		if (position <= 0) {
			System.out.println("Invalid position");
			return;
		}
		if (head == null || position == 1) {
			addAtBeginning(taskId, taskName, priority, dueDate);
			return;
		}

		TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
		TaskNode temp = head;
		for (int i = 1; i < position - 1 && temp.next != head; i++) {
			temp = temp.next;
		}

		newTask.next = temp.next;
		temp.next = newTask;

	}

	@Override
	public void removeById(int id) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		TaskNode curr = head;
		TaskNode prev = null;
		do {
			if (curr.taskId == id) {
				if (curr == head && curr.next == head) {
					head = null;
				} else if (curr == head) {
					TaskNode temp = head;
					while (temp.next != head) {
						temp = temp.next;
					}
					head = head.next;
					temp.next = head;
				} else {
					prev.next = curr.next;
				}
				System.out.println("Task removed: " + id);
				return;
			}
			prev = curr;
			curr = curr.next;
		} while (curr != head);
		System.out.println("Task not found");

	}

	@Override
	public void viewCurrentTask() {
		if (current == null)
			current = head;
		if (current != null) {
			printTask(current);
			current = current.next;
		}

	}

	@Override
	public void displayTasks() {
		if (head == null) {
			System.out.println("No tasks available");
			return;
		}
		TaskNode temp = head;
		do {
			printTask(temp);
			temp = temp.next;
		} while (temp != head);

	}

	@Override
	public void searchByPriority(int priority) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		TaskNode temp = head;
		boolean found = false;
		do {
			if (temp.priority == priority) {
				printTask(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);

		if (!found) {
			System.out.println("No task with priority: " + priority);
		}
	}

	private void printTask(TaskNode task) {
		System.out.println("ID: " + task.taskId + ", Name: " + task.taskName + ", Priority: " + task.priority
				+ ", Due Date: " + task.dueDate);
	}

	public static void main(String[] args) {
		TaskOperations scheduler = new TaskScheduler();

		System.out.println("===== TEST 1: Display empty list =====");
		scheduler.displayTasks(); // No tasks available

		System.out.println("\n===== TEST 2: Remove from empty list =====");
		scheduler.removeById(100); // List is empty

		System.out.println("\n===== TEST 3: Search in empty list =====");
		scheduler.searchByPriority(1); // Nothing found

		System.out.println("\n===== TEST 4: View current task on empty list =====");
		scheduler.viewCurrentTask(); // Should print nothing

		System.out.println("\n===== TEST 5: Add at beginning (first node) =====");
		scheduler.addAtBeginning(1, "Task A", 1, "2025-01-01");
		scheduler.displayTasks();

		System.out.println("\n===== TEST 6: Add at end =====");
		scheduler.addAtEnd(2, "Task B", 2, "2025-01-02");
		scheduler.displayTasks();

		System.out.println("\n===== TEST 7: Add at beginning again =====");
		scheduler.addAtBeginning(3, "Task C", 1, "2025-01-03");
		scheduler.displayTasks();

		System.out.println("\n===== TEST 8: Add at position (middle) =====");
		scheduler.addAtPostion(2, 4, "Task D", 3, "2025-01-04");
		scheduler.displayTasks();

		System.out.println("\n===== TEST 9: Add at position (end) =====");
		scheduler.addAtPostion(10, 5, "Task E", 2, "2025-01-05");
		scheduler.displayTasks();

		System.out.println("\n===== TEST 10: Add at invalid position =====");
		scheduler.addAtPostion(0, 6, "Invalid Task", 5, "2025-01-06");

		System.out.println("\n===== TEST 11: View current task (round-robin) =====");
		scheduler.viewCurrentTask();
		scheduler.viewCurrentTask();
		scheduler.viewCurrentTask();
		scheduler.viewCurrentTask(); // should loop back

		System.out.println("\n===== TEST 12: Search by priority (exists) =====");
		scheduler.searchByPriority(1);

		System.out.println("\n===== TEST 13: Search by priority (not exists) =====");
		scheduler.searchByPriority(99);

		System.out.println("\n===== TEST 14: Remove middle task =====");
		scheduler.removeById(4);
		scheduler.displayTasks();

		System.out.println("\n===== TEST 15: Remove head task =====");
		scheduler.removeById(3);
		scheduler.displayTasks();

		System.out.println("\n===== TEST 16: Remove last task =====");
		scheduler.removeById(5);
		scheduler.displayTasks();

		System.out.println("\n===== TEST 17: Remove non-existing task =====");
		scheduler.removeById(999);

		System.out.println("\n===== TEST 18: Remove remaining tasks =====");
		scheduler.removeById(1);
		scheduler.removeById(2);
		scheduler.displayTasks(); // empty again

		System.out.println("\n===== TEST 19: View current after full deletion =====");
		scheduler.viewCurrentTask(); // safe handling
	}
}
