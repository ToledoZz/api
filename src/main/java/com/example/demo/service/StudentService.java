package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> listar() {
        return repository.findAll();
    }

    public Student guardar(Student student) {
        return repository.save(student);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}