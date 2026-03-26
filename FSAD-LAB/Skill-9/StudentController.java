package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id){
        if(id != 1) throw new StudentNotFoundException("Student not found");
        return "Student Found";
    }
}
