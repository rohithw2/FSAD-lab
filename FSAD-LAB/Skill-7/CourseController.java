package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Course c = service.getCourse(id);
        if (c != null)
            return new ResponseEntity<>(c, HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Course add(@RequestBody Course c) {
        return service.addCourse(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Course c) {
        Course updated = service.updateCourse(id, c);
        if (updated != null)
            return new ResponseEntity<>(updated, HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (service.deleteCourse(id))
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }
}
