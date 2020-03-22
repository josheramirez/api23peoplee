package net.api.apiJava8.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.api.apiJava8.entity.Course;

public interface ICoursesService {
	public List<Course> findAll();
	void guardar(Course course);
	void eliminar(int idCourse);
	public Page<Course> findAllPag(Pageable pageable);
}
