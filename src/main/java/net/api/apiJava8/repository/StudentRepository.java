package net.api.apiJava8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.api.apiJava8.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
