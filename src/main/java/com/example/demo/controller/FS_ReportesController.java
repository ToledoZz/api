package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Reportes;
import com.example.demo.service.FS_ReportesService;

@RestController
@RequestMapping("/api/fsreportes")
@CrossOrigin
public class FS_ReportesController {

    @Autowired
    private FS_ReportesService service;

    @GetMapping
    public List<FS_Reportes> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Reportes guardar(@RequestBody FS_Reportes reporte) {

        reporte.setReporteId(null);

        return service.guardar(reporte);
    }

    @PutMapping("/{id}")
    public FS_Reportes editar(
            @PathVariable Integer id,
            @RequestBody FS_Reportes reporte
    ) {

        reporte.setReporteId(id);

        return service.guardar(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}