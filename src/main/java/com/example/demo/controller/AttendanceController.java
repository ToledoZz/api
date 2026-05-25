package com.example.demo.controller;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {

    private final AttendanceRepository repository;

    public AttendanceController(AttendanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Attendance> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Attendance save(@RequestBody Attendance attendance) {

        attendance.setDetectedAt(LocalDateTime.now());

        return repository.save(attendance);
    }
}