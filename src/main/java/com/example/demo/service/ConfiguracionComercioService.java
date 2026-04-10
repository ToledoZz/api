package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ConfiguracionComercio;
import com.example.demo.repository.ConfiguracionComercioRepository;

@Service
public class ConfiguracionComercioService {

    @Autowired
    private ConfiguracionComercioRepository repository;

    public List<ConfiguracionComercio> listar(){
        return repository.findAll();
    }

    public ConfiguracionComercio guardar(ConfiguracionComercio config){

        if(repository.existsByIdComercio(config.getIdComercio())){
            throw new RuntimeException("Ya existe configuración para este comercio");
        }

        config.setFechaDeRegistro(new Date());
        config.setEstado(true);

        return repository.save(config);
    }

    public ConfiguracionComercio editar(Integer id, ConfiguracionComercio config){

        ConfiguracionComercio actual = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Configuración no encontrada"));

        actual.setTipoConfiguracion(config.getTipoConfiguracion());
        actual.setComision(config.getComision());
        actual.setEstado(config.getEstado());
        actual.setFechaDeModificacion(new Date());

        return repository.save(actual);
    }

    public ConfiguracionComercio obtenerPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

}