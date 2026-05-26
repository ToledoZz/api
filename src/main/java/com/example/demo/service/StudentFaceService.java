/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.service;

import com.example.demo.model.StudentFace;
import com.example.demo.repository.StudentFaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFaceService {

    @Autowired
    private StudentFaceRepository repository;

    public StudentFace guardar(StudentFace face) {
        return repository.save(face);
    }

    public List<StudentFace> listar() {
        return repository.findAll();
    }
}