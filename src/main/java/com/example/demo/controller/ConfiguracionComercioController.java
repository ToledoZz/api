package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ConfiguracionComercio;
import com.example.demo.service.ConfiguracionComercioService;

@RestController
@RequestMapping("/api/configuracion-comercio")
@CrossOrigin
public class ConfiguracionComercioController {

    @Autowired
    private ConfiguracionComercioService service;

    @GetMapping
    public List<ConfiguracionComercio> listar(){
        return service.listar();
    }

    @PostMapping
    public ConfiguracionComercio guardar(@RequestBody ConfiguracionComercio config){
        return service.guardar(config);
    }

    @PutMapping("/{id}")
    public ConfiguracionComercio editar(
            @PathVariable Integer id,
            @RequestBody ConfiguracionComercio config){

        return service.editar(id, config);
    }

    @GetMapping("/{id}")
    public ConfiguracionComercio obtener(@PathVariable Integer id){
        return service.obtenerPorId(id);
    }
}