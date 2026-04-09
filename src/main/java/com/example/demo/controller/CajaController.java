package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Caja;
import com.example.demo.service.CajaService;

@RestController
@RequestMapping("/api/cajas")
@CrossOrigin
public class CajaController {

    @Autowired
    private CajaService service;

    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<Caja> listar(){
        return service.listar();
    }

    // =========================
    // GET BY ID 🔥
    // =========================
    @GetMapping("/{id}")
    public Caja obtenerPorId(@PathVariable Integer id){
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Caja no encontrada"));
    }

    // =========================
    // POST
    // =========================
    @PostMapping
    public Caja guardar(@RequestBody Caja caja){
        return service.guardar(caja);
    }

    // =========================
    // PUT (EDITAR / CERRAR) 🔥
    // =========================
    @PutMapping("/{id}")
    public Caja actualizar(@PathVariable Integer id, @RequestBody Caja caja){
        Caja existente = service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Caja no encontrada"));

        existente.setComercio(caja.getComercio());
        existente.setFechaApertura(caja.getFechaApertura());
        existente.setFechaCierre(caja.getFechaCierre());
        existente.setEstaAbierta(caja.getEstaAbierta());
        existente.setMontoFinal(caja.getMontoFinal());

        return service.guardar(existente);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }
}