package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_SolicitudesAmistad;
import com.example.demo.service.FS_SolicitudesAmistadService;

@RestController
@RequestMapping("/api/fssolicitudesamistad")
@CrossOrigin
public class FS_SolicitudesAmistadController {

    @Autowired
    private FS_SolicitudesAmistadService service;

    @GetMapping
    public List<FS_SolicitudesAmistad> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_SolicitudesAmistad guardar(@RequestBody FS_SolicitudesAmistad solicitud) {

        solicitud.setSolicitudId(null);

        return service.guardar(solicitud);
    }

    @PutMapping("/{id}")
    public FS_SolicitudesAmistad editar(
            @PathVariable Integer id,
            @RequestBody FS_SolicitudesAmistad solicitud
    ) {

        solicitud.setSolicitudId(id);

        return service.guardar(solicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}