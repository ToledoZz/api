package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Comentarios;
import com.example.demo.service.FS_ComentariosService;

@RestController
@RequestMapping("/api/fscomentarios")
@CrossOrigin
public class FS_ComentariosController {

    @Autowired
    private FS_ComentariosService service;

    @GetMapping
    public List<FS_Comentarios> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Comentarios guardar(@RequestBody FS_Comentarios comentario) {

        comentario.setComentarioId(null);

        return service.guardar(comentario);
    }

    @PutMapping("/{id}")
    public FS_Comentarios editar(
            @PathVariable Integer id,
            @RequestBody FS_Comentarios comentario
    ) {

        comentario.setComentarioId(id);

        return service.guardar(comentario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}