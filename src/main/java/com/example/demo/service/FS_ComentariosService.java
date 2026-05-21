package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Comentarios;
import com.example.demo.repository.FS_ComentariosRepository;

@Service
public class FS_ComentariosService {

    @Autowired
    private FS_ComentariosRepository repository;

    public List<FS_Comentarios> listar() {
        return repository.findAll();
    }

    public FS_Comentarios guardar(FS_Comentarios comentario) {
        return repository.save(comentario);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}