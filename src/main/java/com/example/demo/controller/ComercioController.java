package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Comercio;
import com.example.demo.service.ComercioService;

@RestController
@RequestMapping("/api/comercios")
@CrossOrigin
public class ComercioController {

    @Autowired
    private ComercioService service;

    @GetMapping
    public List<Comercio> listar(){
        return service.listar();
    }

    @PostMapping
    public Comercio guardar(@RequestBody Comercio comercio){
        return service.guardar(comercio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }

}