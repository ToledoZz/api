package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Mensajes;
import com.example.demo.repository.FS_MensajesRepository;

@Service
public class FS_MensajesService {

    @Autowired
    private FS_MensajesRepository repository;

    public List<FS_Mensajes> listar() {
        return repository.findAll();
    }

    public FS_Mensajes guardar(FS_Mensajes mensaje) {
        return repository.save(mensaje);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}