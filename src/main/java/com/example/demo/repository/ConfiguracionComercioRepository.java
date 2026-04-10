package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ConfiguracionComercio;

public interface ConfiguracionComercioRepository 
extends JpaRepository<ConfiguracionComercio, Integer>{

    boolean existsByIdComercio(Integer idComercio);

}