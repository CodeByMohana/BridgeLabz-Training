package com.oop.gcrcodebase.constructorsandinstances;

public class Course {
	private String courseName;
	private int duration;
	private double fee;

	private static String instituteName = "Default Name";

	public Course(String courseName, int duration, double fee) {
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}

	// Instance Method to display course details
	public void displayCourseDetails() {
		System.out.println("Course Name: " + courseName);
		System.out.println("Duration: " + duration);
		System.out.println("Fee: " + fee);
		System.out.println("Institute: " + instituteName);
		System.out.println("----------------------------");
	}

	public static void updateInstituteName(String instituteName) {
		Course.instituteName = instituteName;
	}
	
	public static void main(String[] args) {
		// Set initial institute name
        Course.updateInstituteName("Tech Academy");

        // Create Course objects
        Course course1 = new Course("Java Programming", 12, 6000.0);
        Course course2 = new Course("Web Development", 10, 7500.0);

        // Display course details
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("Code Masters Institute");

        // Display course details again to reflect change
        course1.displayCourseDetails();
        course2.displayCourseDetails();
	}
	

}
