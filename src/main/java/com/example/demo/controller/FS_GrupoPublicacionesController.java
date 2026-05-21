package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_GrupoPublicaciones;
import com.example.demo.service.FS_GrupoPublicacionesService;

@RestController
@RequestMapping("/api/fsgrupopublicaciones")
@CrossOrigin
public class FS_GrupoPublicacionesController {

    @Autowired
    private FS_GrupoPublicacionesService service;

    @GetMapping
    public List<FS_GrupoPublicaciones> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_GrupoPublicaciones guardar(@RequestBody FS_GrupoPublicaciones publicacion) {

        publicacion.setGrupoPublicacionId(null);

        return service.guardar(publicacion);
    }

    @PutMapping("/{id}")
    public FS_GrupoPublicaciones editar(
            @PathVariable Integer id,
            @RequestBody FS_GrupoPublicaciones publicacion
    ) {

        publicacion.setGrupoPublicacionId(id);

        return service.guardar(publicacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}