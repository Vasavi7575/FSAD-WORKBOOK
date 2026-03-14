package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.service.StudentService;
import com.klu.exception.InvalidInputException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {

        if (id <= 0) {
            throw new InvalidInputException("Student ID must be positive");
        }

        return service.getStudentById(id);
    }

}