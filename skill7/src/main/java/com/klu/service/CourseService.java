package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.entity.Course;
import com.klu.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return repository.findById(id);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        return repository.findById(id).map(course -> {
            course.setTitle(courseDetails.getTitle());
            course.setDuration(courseDetails.getDuration());
            course.setFee(courseDetails.getFee());
            return repository.save(course);
        }).orElse(null);
    }

    public boolean deleteCourse(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Course> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}