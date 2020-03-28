package net.api.apiJava8.errors;

public class CourseNotFoundException extends Exception {
private int course_id;
public CourseNotFoundException(int course_id) {
        super(String.format("Book is not found with id : '%s'", course_id));
        }
}