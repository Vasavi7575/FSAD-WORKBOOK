package com.klu.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}