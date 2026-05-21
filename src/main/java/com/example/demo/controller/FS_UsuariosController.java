package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Usuarios;
import com.example.demo.service.FS_UsuariosService;

@RestController
@RequestMapping("/api/fsusuarios")
@CrossOrigin
public class FS_UsuariosController {

    @Autowired
    private FS_UsuariosService service;

    @GetMapping
    public List<FS_Usuarios> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Usuarios guardar(@RequestBody FS_Usuarios usuario) {

        usuario.setUsuarioId(null);

        return service.guardar(usuario);
    }

    @PutMapping("/{id}")
    public FS_Usuarios editar(
            @PathVariable Integer id,
            @RequestBody FS_Usuarios usuario
    ) {

        usuario.setUsuarioId(id);

        return service.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}