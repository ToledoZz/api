package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Reportes;
import com.example.demo.repository.FS_ReportesRepository;

@Service
public class FS_ReportesService {

    @Autowired
    private FS_ReportesRepository repository;

    public List<FS_Reportes> listar() {
        return repository.findAll();
    }

    public FS_Reportes guardar(FS_Reportes reporte) {
        return repository.save(reporte);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}