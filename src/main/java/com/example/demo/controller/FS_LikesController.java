package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Likes;
import com.example.demo.service.FS_LikesService;

@RestController
@RequestMapping("/api/fslikes")
@CrossOrigin
public class FS_LikesController {

    @Autowired
    private FS_LikesService service;

    @GetMapping
    public List<FS_Likes> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Likes guardar(@RequestBody FS_Likes like) {

        like.setLikeId(null);

        return service.guardar(like);
    }

    @PutMapping("/{id}")
    public FS_Likes editar(
            @PathVariable Integer id,
            @RequestBody FS_Likes like
    ) {

        like.setLikeId(id);

        return service.guardar(like);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}