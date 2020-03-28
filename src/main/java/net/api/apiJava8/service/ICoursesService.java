package net.api.apiJava8.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.api.apiJava8.entity.Course;

public interface ICoursesService {
	public List<Course> findAllPag(Pageable pageable);
	public List<Course> findAll();
	public Course findById(int id);
	public void save(Course course);
	public void delete(int idCourse);
}
