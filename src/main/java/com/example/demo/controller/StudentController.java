package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    // =========================
    // GET ALL
    // =========================

    @GetMapping
    public List<Student> listar() {
        return service.listar();
    }

    // =========================
    // SAVE STUDENT
    // =========================

    @PostMapping
    public Student guardar(@RequestBody Student student) {

        student.setId(null);

        return service.guardar(student);
    }

    // =========================
    // START FACE REGISTRATION
    // =========================

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

            return "Camera opened";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =========================
    // DELETE
    // =========================

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}