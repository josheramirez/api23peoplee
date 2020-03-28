package net.api.apiJava8.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.api.apiJava8.entity.Course;
import net.api.apiJava8.entity.Student;
import net.api.apiJava8.errors.UserNotFoundException;
import net.api.apiJava8.repository.CoursesRepository;
import net.api.apiJava8.repository.StudentRepository;
import net.api.apiJava8.service.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private StudentRepository repoStudent;
	
	@Override
	public List<Student> findAllPag(Pageable pageable) {
	  Pageable paging = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());
	  Page<Student> pagedResult = repoStudent.findAll(paging);
	  return pagedResult.getContent();
	}

	@Override
	public List<Student> findAll() {
		return repoStudent.findAll();
	}

	@Override
	public Student findById(int id) {
		Optional<Student> student= repoStudent.findById(id);
		if(!student.isPresent()) {
			throw new UserNotFoundException("id: "+ id);  
		}
		return student.get();
	}

	@Override
	public void saveStudent(Student student) {
		repoStudent.save(student);
	}

	@Override
	public void delete(int idStudent) {
		repoStudent.deleteById(idStudent);
	}

}
