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
    public List<Comercio> listar() {
        return service.listar();
    }

    @PostMapping
    public Comercio guardar(@RequestBody Comercio comercio) {
        comercio.setIdComercio(null); // asegurar creación nueva
        return service.guardar(comercio);
    }

    @PutMapping("/{id}")
    public Comercio editar(@PathVariable Integer id, @RequestBody Comercio comercio) {
        comercio.setIdComercio(id);
        return service.guardar(comercio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}