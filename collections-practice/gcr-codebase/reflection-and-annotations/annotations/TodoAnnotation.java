package com.collections.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
	String task();

	String assignedTo();

	String priority() default " HIGH";
}

class ProjectTasks {
	@Todo(task = "Implement user authentication", assignedTo = "Sai", priority = "HIGH")
	public void loginFeature() {
		// pending
	}

	@Todo(task = "Add payment gateway", assignedTo = "Rahul")
	public void paymentGateway() {
		// pending
	}

	@Todo(task = "Optimize database queries", assignedTo = "Anita", priority = "LOW")
	public void optimizeDB() {
		// pending
	}

	public void completedFeature() {
		// not pending
	}
}

public class TodoAnnotation {
	
	public static void main(String[] args) {
		Class<?> cls = ProjectTasks.class;
		
		System.out.println("Pending Tasks: \n");
		
		for(Method method : cls.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Todo.class)) {
				Todo todo = method.getAnnotation(Todo.class);
				
				System.out.println("Method Name : " + method.getName());
				System.out.println("Task        : " + todo.task());
				System.out.println("Assigned To : " + todo.assignedTo());
				System.out.println("Priority    : " + todo.priority());
				System.out.println("--------------------------");
					
			}
		}
	}

}
