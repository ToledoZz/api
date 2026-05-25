package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public List<Attendance> listar() {
        return repository.findAll();
    }

    public Attendance guardar(Attendance attendance) {

        attendance.setDetectedAt(LocalDateTime.now());

        return repository.save(attendance);
    }
}