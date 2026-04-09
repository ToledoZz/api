package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Caja;
import com.example.demo.repository.CajaRepository;
import java.util.Optional;

@Service
public class CajaService {

    @Autowired
    private CajaRepository repository;

    public List<Caja> listar(){
        return repository.findAll();
    }

    public Caja guardar(Caja caja){
        return repository.save(caja);
    }

    public void eliminar(Integer id){
        repository.deleteById(id);
    }
    
    public Optional<Caja> obtenerPorId(Integer id){
    return repository.findById(id);
}
}