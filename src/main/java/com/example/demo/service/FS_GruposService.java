package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Grupos;
import com.example.demo.repository.FS_GruposRepository;

@Service
public class FS_GruposService {

    @Autowired
    private FS_GruposRepository repository;

    public List<FS_Grupos> listar() {
        return repository.findAll();
    }

    public FS_Grupos guardar(FS_Grupos grupo) {
        return repository.save(grupo);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}