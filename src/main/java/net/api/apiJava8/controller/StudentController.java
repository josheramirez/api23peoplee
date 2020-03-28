package net.api.apiJava8.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.entity.Student;
import net.api.apiJava8.service.IStudentService;


@RestController
public class StudentController {
	
	@Autowired
	private IStudentService serviceStudent;
	
	@GetMapping("/students/all")
	public List<Student> findAll(){
		return serviceStudent.findAll();
	}
	
	@PostMapping("/students")
	public Student save(@Valid @RequestBody Student student) {
		serviceStudent.saveStudent(student);
		return student;
	}
	
	@GetMapping("/students/{id}")
	public Student findStudent(@PathVariable int id){
		return serviceStudent.findById(id);
	}
	
	@PutMapping("/students/{id}")
	public Student update(@Valid @RequestBody Student studentDetails, @PathVariable int id){
		Student student=serviceStudent.findById(id);
		student.setName(studentDetails.getName());
        student.setRut(studentDetails.getRut());
        student.setLastName(studentDetails.getLastName());
        student.setAge(studentDetails.getAge());
        student.setCourse(studentDetails.getCourse());
        serviceStudent.saveStudent(student);
		return student;
	}
	
	@GetMapping("/students")
	List<Student> findAllPag(Pageable pageable) {
		return serviceStudent.findAllPag(pageable);

	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity deleteStudent(@PathVariable int id) {
		serviceStudent.delete(id); 
		return new ResponseEntity<>("course deleted!", HttpStatus.OK);
	}
	
}