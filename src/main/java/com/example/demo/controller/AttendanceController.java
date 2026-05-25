package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @GetMapping
    public List<Attendance> listar() {
        return service.listar();
    }

    @PostMapping
    public Attendance guardar(@RequestBody Attendance attendance) {
        return service.guardar(attendance);
    }
}