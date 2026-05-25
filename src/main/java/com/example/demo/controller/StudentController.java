package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping("/start-registration")
public String startRegistration(
        @RequestParam String name,
        @RequestParam String email
) {

    try {

        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                "C:/Users/cerda/smartattendance/ai-service/register_student.py",
                name,
                email
        );

        processBuilder.start();

        return "Face registration started";

    } catch (Exception e) {

        return e.getMessage();
    }
}

    @PostMapping
    public Student save(@RequestBody Student student) {
        return repository.save(student);
    }
}