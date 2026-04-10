package com.example.demo.controller;

import com.example.demo.model.BitacoraEvento;
import com.example.demo.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitacora")
@CrossOrigin
public class BitacoraController {

    @Autowired
    private BitacoraService service;

    @GetMapping
    public List<BitacoraEvento> listar() {
        return service.listar();
    }
}