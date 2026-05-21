package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Publicaciones;
import com.example.demo.service.FS_PublicacionesService;

@RestController
@RequestMapping("/api/fspublicaciones")
@CrossOrigin
public class FS_PublicacionesController {

    @Autowired
    private FS_PublicacionesService service;

    @GetMapping
    public List<FS_Publicaciones> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Publicaciones guardar(@RequestBody FS_Publicaciones publicacion) {

        publicacion.setPublicacionId(null);

        return service.guardar(publicacion);
    }

    @PutMapping("/{id}")
    public FS_Publicaciones editar(
            @PathVariable Integer id,
            @RequestBody FS_Publicaciones publicacion
    ) {

        publicacion.setPublicacionId(id);

        return service.guardar(publicacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}