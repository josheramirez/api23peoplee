package net.api.apiJava8.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.errors.UserNotFoundException;
import net.api.apiJava8.repository.CoursesRepository;
import net.api.apiJava8.service.ICoursesService;



@Service
public class CoursesService implements ICoursesService {
	
	@Autowired
	private CoursesRepository repoCourses;
	
	public List<Course> findAll() {
		return repoCourses.findAll();
	}

	public void save(Course course) {	
		repoCourses.save(course);
	}

	public void delete(int idCourse) {
		repoCourses.deleteById(idCourse);
	}
	
	public List<Course> findAllPag(Pageable pageable) {
		 System.out.println(pageable.getPageNumber());

        Pageable paging = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());
        Page<Course> pagedResult = repoCourses.findAll(paging);

        return pagedResult.getContent();
//        return repoCourses.findAll(pageable);
	}

	
	public Course findById(int id) {
		Optional<Course> course=repoCourses.findById(id);
		if(!course.isPresent()) {
			System.out.println("es vaciuo"+course);
			throw new UserNotFoundException("id: "+ id);  
		}
		
		return course.get();
	}


}
