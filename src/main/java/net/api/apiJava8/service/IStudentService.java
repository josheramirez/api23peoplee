package net.api.apiJava8.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.entity.Student;


public interface IStudentService {
	public List<Student> findAllPag(Pageable pageable);
	public List<Student> findAll();
	public Student findById(int id);
	public void saveStudent(Student student);
	public void delete(int idStudent);
}
