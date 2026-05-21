package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_GrupoMiembros;
import com.example.demo.repository.FS_GrupoMiembrosRepository;

@Service
public class FS_GrupoMiembrosService {

    @Autowired
    private FS_GrupoMiembrosRepository repository;

    public List<FS_GrupoMiembros> listar() {
        return repository.findAll();
    }

    public FS_GrupoMiembros guardar(FS_GrupoMiembros miembro) {
        return repository.save(miembro);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}