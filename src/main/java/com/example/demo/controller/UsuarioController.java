package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // Listar usuarios
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Registrar usuario
    @PostMapping
    public Usuario guardar(@Valid @RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    // Editar usuario
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        Usuario existente = service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setComercio(usuario.getComercio());
        existente.setIdNetUser(usuario.getIdNetUser());
        existente.setNombres(usuario.getNombres());
        existente.setPrimerApellido(usuario.getPrimerApellido());
        existente.setSegundoApellido(usuario.getSegundoApellido());
        existente.setIdentificacion(usuario.getIdentificacion());
        existente.setCorreoElectronico(usuario.getCorreoElectronico());
        existente.setEstado(usuario.getEstado());
        existente.setFechaDeModificacion(new java.util.Date());

        return service.guardar(existente);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}