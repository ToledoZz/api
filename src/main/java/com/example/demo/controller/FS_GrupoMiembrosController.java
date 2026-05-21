package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_GrupoMiembros;
import com.example.demo.service.FS_GrupoMiembrosService;

@RestController
@RequestMapping("/api/fsgrupomiembros")
@CrossOrigin
public class FS_GrupoMiembrosController {

    @Autowired
    private FS_GrupoMiembrosService service;

    @GetMapping
    public List<FS_GrupoMiembros> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_GrupoMiembros guardar(@RequestBody FS_GrupoMiembros miembro) {

        miembro.setMiembroId(null);

        return service.guardar(miembro);
    }

    @PutMapping("/{id}")
    public FS_GrupoMiembros editar(
            @PathVariable Integer id,
            @RequestBody FS_GrupoMiembros miembro
    ) {

        miembro.setMiembroId(id);

        return service.guardar(miembro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}