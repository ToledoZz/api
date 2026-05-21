package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Likes;
import com.example.demo.repository.FS_LikesRepository;

@Service
public class FS_LikesService {

    @Autowired
    private FS_LikesRepository repository;

    public List<FS_Likes> listar() {
        return repository.findAll();
    }

    public FS_Likes guardar(FS_Likes like) {
        return repository.save(like);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}