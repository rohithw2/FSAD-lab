package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourse(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course addCourse(Course c) {
        return repo.save(c);
    }

    public Course updateCourse(int id, Course c) {
        if (repo.existsById(id)) {
            c.setCourseId(id);
            return repo.save(c);
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
