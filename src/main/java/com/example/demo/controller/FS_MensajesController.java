package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Mensajes;
import com.example.demo.service.FS_MensajesService;

@RestController
@RequestMapping("/api/fsmensajes")
@CrossOrigin
public class FS_MensajesController {

    @Autowired
    private FS_MensajesService service;

    @GetMapping
    public List<FS_Mensajes> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Mensajes guardar(@RequestBody FS_Mensajes mensaje) {

        mensaje.setMensajeId(null);

        return service.guardar(mensaje);
    }

    @PutMapping("/{id}")
    public FS_Mensajes editar(
            @PathVariable Integer id,
            @RequestBody FS_Mensajes mensaje
    ) {

        mensaje.setMensajeId(id);

        return service.guardar(mensaje);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}