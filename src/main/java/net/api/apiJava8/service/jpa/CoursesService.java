package net.api.apiJava8.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.repository.CoursesRepository;
import net.api.apiJava8.service.ICoursesService;



@Service
public class CoursesService implements ICoursesService {
	
	@Autowired
	private CoursesRepository repoCourses;
	
	public List<Course> findAll() {
		return repoCourses.findAll();
	}

	public void guardar(Course course) {	
		repoCourses.save(course);
	}

	public void eliminar(int idCourse) {
		repoCourses.deleteById(idCourse);
	}
	
	@Override
	public Page<Course> findAllPag(Pageable pageable) {
		// TODO Auto-generated method stub
		return repoCourses.findAll(pageable);
	}


}
