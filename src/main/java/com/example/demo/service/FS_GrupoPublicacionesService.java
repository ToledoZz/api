package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_GrupoPublicaciones;
import com.example.demo.repository.FS_GrupoPublicacionesRepository;

@Service
public class FS_GrupoPublicacionesService {

    @Autowired
    private FS_GrupoPublicacionesRepository repository;

    public List<FS_GrupoPublicaciones> listar() {
        return repository.findAll();
    }

    public FS_GrupoPublicaciones guardar(FS_GrupoPublicaciones publicacion) {
        return repository.save(publicacion);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}