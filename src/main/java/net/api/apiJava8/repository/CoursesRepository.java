package net.api.apiJava8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.api.apiJava8.entity.Course;

public interface CoursesRepository extends JpaRepository <Course, Integer>, PagingAndSortingRepository<Course, Integer> {

}
