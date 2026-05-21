package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Grupos;
import com.example.demo.service.FS_GruposService;

@RestController
@RequestMapping("/api/fsgrupos")
@CrossOrigin
public class FS_GruposController {

    @Autowired
    private FS_GruposService service;

    @GetMapping
    public List<FS_Grupos> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Grupos guardar(@RequestBody FS_Grupos grupo) {

        grupo.setGrupoId(null);

        return service.guardar(grupo);
    }

    @PutMapping("/{id}")
    public FS_Grupos editar(
            @PathVariable Integer id,
            @RequestBody FS_Grupos grupo
    ) {

        grupo.setGrupoId(id);

        return service.guardar(grupo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}