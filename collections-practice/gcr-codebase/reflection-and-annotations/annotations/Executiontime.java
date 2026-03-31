package com.collections.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformTasks {

	@LogExecutionTime
	public void fastTask() {
		for (int i = 0; i < 1_000; i++) {
			Math.sqrt(i);
		}
	}

	@LogExecutionTime
	public void slowTask() {
		for (int i = 0; i < 10_000_000; i++) {
			Math.sqrt(i);
		}
	}

	public void normalTask() {
		System.out.println("No logging here");
	}
}

public class Executiontime {
	public static void main(String[] args) throws Exception {
		PerformTasks obj = new PerformTasks();
		Class<?> cls = obj.getClass();

		for (Method method : cls.getDeclaredMethods()) {
			if (method.isAnnotationPresent(LogExecutionTime.class)) {
				long start = System.nanoTime();
				method.invoke(obj);

				long end = System.nanoTime();

				long duration = end - start;
				System.out.println(method.getName() + " executed in " + duration + " nanoseconds");
			}
		}
	}
}
