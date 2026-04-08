package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Caja;
import com.example.demo.service.CajaService;

@RestController
@RequestMapping("/api/cajas")
@CrossOrigin
public class CajaController {

    @Autowired
    private CajaService service;

    @GetMapping
    public List<Caja> listar(){
        return service.listar();
    }

    @PostMapping
    public Caja guardar(@RequestBody Caja caja){
        return service.guardar(caja);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }
}