package net.api.apiJava8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.api.apiJava8.entity.Course;

@Repository
public interface CoursesRepository extends JpaRepository <Course, Integer> {

}
