package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Sinpe;
import com.example.demo.service.SinpeService;

@RestController
@RequestMapping("/api/sinpes")
@CrossOrigin
public class SinpeController {

    @Autowired
    private SinpeService service;

    // CRUD
    @GetMapping
    public List<Sinpe> listar(){
        return service.listar();
    }

    @PostMapping
    public Sinpe guardar(@RequestBody Sinpe sinpe){
        return service.guardar(sinpe);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }

    // 🔥 SINCRONIZAR
    @PutMapping("/{id}/sincronizar")
    public Sinpe sincronizar(@PathVariable Integer id){
        return service.sincronizar(id);
    }

    // 🔥 NO SINCRONIZADOS
    @GetMapping("/no-sincronizados")
    public List<Sinpe> noSincronizados(){
        return service.noSincronizados();
    }

    // 🔥 FILTRO POR FECHA
    @GetMapping("/por-fecha")
    public List<Sinpe> porFecha(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin
    ){
        return service.porFecha(inicio, fin);
    }

    // 🔥 POR COMERCIO
    @GetMapping("/comercio/{id}")
    public List<Sinpe> porComercio(@PathVariable Integer id){
        return service.porComercio(id);
    }

    // 🔥 POR COMERCIO Y FECHA
    @GetMapping("/comercio/{id}/fecha")
    public List<Sinpe> porComercioYFecha(
        @PathVariable Integer id,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin
    ){
        return service.porComercioYFecha(id, inicio, fin);
    }

    // 🔥 REPORTES

    @GetMapping("/total")
    public Double totalGeneral(){
        return service.totalGeneral();
    }

    @GetMapping("/total/{idComercio}")
    public Double totalPorComercio(@PathVariable Integer idComercio){
        return service.totalPorComercio(idComercio);
    }

    @GetMapping("/total-fecha")
    public Double totalPorFecha(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin
    ){
        return service.totalPorFecha(inicio, fin);
    }

    @GetMapping("/total-comercio-fecha/{id}")
    public Double totalPorComercioYFecha(
        @PathVariable Integer id,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin
    ){
        return service.totalPorComercioYFecha(id, inicio, fin);
    }

    // 🔥 CANTIDADES

    @GetMapping("/cantidad")
    public Long cantidadTotal(){
        return service.cantidadTotal();
    }

    @GetMapping("/cantidad/{id}")
    public Long cantidadPorComercio(@PathVariable Integer id){
        return service.cantidadPorComercio(id);
    }

    @GetMapping("/cantidad-no-sincronizados")
    public Long cantidadNoSincronizados(){
        return service.cantidadNoSincronizados();
    }
}