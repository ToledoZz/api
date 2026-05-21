package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Marketplace;
import com.example.demo.repository.FS_MarketplaceRepository;

@Service
public class FS_MarketplaceService {

    @Autowired
    private FS_MarketplaceRepository repository;

    public List<FS_Marketplace> listar() {
        return repository.findAll();
    }

    public FS_Marketplace guardar(FS_Marketplace marketplace) {
        return repository.save(marketplace);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}