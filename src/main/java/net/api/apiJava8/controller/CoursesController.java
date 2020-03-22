package net.api.apiJava8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.service.ICoursesService;

@RestController
@RequestMapping("/api")
public class CoursesController {
	
	@Autowired
	private ICoursesService serviceCourses;
	
	@GetMapping("/courses")
	public List<Course> findAllPag(){
		return serviceCourses.findAll();
	}
	
	@GetMapping("/courses/all")
	public List<Course> findAll(){
		return serviceCourses.findAll();
	}
	
	@PostMapping("/courses")
	public Course guardar(@RequestBody Course course) {
		serviceCourses.guardar(course);
		return course;
	}
	
	@PutMapping("/courses")
	public Course modificar(@RequestBody Course course){
		serviceCourses.guardar(course);
		return course;
	}
	
//	@DeleteMapping("/courses/{id}")
//	public String eliminar(@PathVariable("id") int idCourse) {
//		serviceCourses.eliminar(idCourse);
//		return "Course Removed!";
//	}
//	
//''
}
