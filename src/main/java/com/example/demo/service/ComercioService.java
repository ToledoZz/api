package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comercio;
import com.example.demo.repository.ComercioRepository;

@Service
public class ComercioService {

    @Autowired
    private ComercioRepository repository;

    public List<Comercio> listar(){
        return repository.findAll();
    }

    public Comercio guardar(Comercio comercio){
        return repository.save(comercio);
    }

    public void eliminar(Integer id){
        repository.deleteById(id);
    }

}