package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_SolicitudesAmistad;
import com.example.demo.repository.FS_SolicitudesAmistadRepository;

@Service
public class FS_SolicitudesAmistadService {

    @Autowired
    private FS_SolicitudesAmistadRepository repository;

    public List<FS_SolicitudesAmistad> listar() {
        return repository.findAll();
    }

    public FS_SolicitudesAmistad guardar(FS_SolicitudesAmistad solicitud) {
        return repository.save(solicitud);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}