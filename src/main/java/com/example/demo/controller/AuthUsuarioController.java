package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.AuthUsuario;
import com.example.demo.service.AuthUsuarioService;

@RestController
@RequestMapping("/api/authusuarios")
@CrossOrigin
public class AuthUsuarioController {

    @Autowired
    private AuthUsuarioService service;

    // GET ALL
    @GetMapping
    public List<AuthUsuario> listar() {
        return service.listar();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public AuthUsuario obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // POST
    @PostMapping
    public AuthUsuario guardar(@RequestBody AuthUsuario usuario) {
        return service.guardar(usuario);
    }

    // PUT
    @PutMapping("/{id}")
    public AuthUsuario actualizar(@PathVariable Integer id, @RequestBody AuthUsuario usuario) {

        AuthUsuario existente = service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setCorreo(usuario.getCorreo());
        existente.setPasswordHash(usuario.getPasswordHash());
        existente.setRol(usuario.getRol());
        existente.setIdComercio(usuario.getIdComercio());

        return service.guardar(existente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}