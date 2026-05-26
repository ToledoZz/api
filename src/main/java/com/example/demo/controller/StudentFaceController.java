/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.StudentFace;
import com.example.demo.service.StudentFaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faces")
@CrossOrigin
public class StudentFaceController {

    @Autowired
    private StudentFaceService service;

    @PostMapping
    public StudentFace save(@RequestBody StudentFace face) {
        return service.guardar(face);
    }

    @GetMapping
    public List<StudentFace> listar() {
        return service.listar();
    }
}