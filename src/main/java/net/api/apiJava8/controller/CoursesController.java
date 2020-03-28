package net.api.apiJava8.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.api.apiJava8.config.JwtUtil;
import net.api.apiJava8.entity.AuthRequest;
import net.api.apiJava8.entity.Course;
import net.api.apiJava8.errors.CourseNotFoundException;
import net.api.apiJava8.errors.UserNotFoundException;
import net.api.apiJava8.service.ICoursesService;
import net.api.apiJava8.service.jpa.CustomUserDetailsService;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class CoursesController {
	
	@Autowired
	private ICoursesService serviceCourses;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService service;
	
	@GetMapping("/courses/{id}")
	public Course findCourse(@PathVariable int id){	
		return   serviceCourses.findById(id);
	}
	
	@GetMapping("/courses/all")
	public List<Course> findAll(){
		return serviceCourses.findAll();
	}
	
	@PostMapping("/courses")
	public Course guardar(@Valid @RequestBody Course course) {
		serviceCourses.save(course);
		return course;
	}
	
	@PutMapping("/courses/{id}")
	public Course modificar(@Valid @RequestBody Course courseDetails, @PathVariable int id){
		Course course=serviceCourses.findById(id);
		course.setName(courseDetails.getName());
        course.setCode(courseDetails.getCode());
        serviceCourses.save(course);
		return course;
	}
	
	@GetMapping("/courses")
	List<Course> findAllPag(Pageable pageable) {
		return serviceCourses.findAllPag(pageable);

	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity deleteCourse(@PathVariable int id) {
		serviceCourses.delete(id); 
		return new ResponseEntity("course deleted!", HttpStatus.OK);
	}

	@GetMapping("/token")
//	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
		public String generateToken() throws Exception {
//		try {
//				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("techgeeknext","password")
//				);
//		}catch(Exception ex) {
//			throw  new Exception("invalid user pass");
//		}	
		return jwtUtil.generateToken("invite_user");
	}
	
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	
}
