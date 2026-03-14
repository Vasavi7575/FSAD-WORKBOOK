package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.entity.Student;
import com.klu.repository.StudentRepository;
import com.klu.exception.StudentNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student getStudentById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

}