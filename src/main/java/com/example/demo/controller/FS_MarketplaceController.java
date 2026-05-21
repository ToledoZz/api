package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FS_Marketplace;
import com.example.demo.service.FS_MarketplaceService;

@RestController
@RequestMapping("/api/fsmarketplace")
@CrossOrigin
public class FS_MarketplaceController {

    @Autowired
    private FS_MarketplaceService service;

    @GetMapping
    public List<FS_Marketplace> listar() {
        return service.listar();
    }

    @PostMapping
    public FS_Marketplace guardar(@RequestBody FS_Marketplace marketplace) {

        marketplace.setMarketplaceId(null);

        return service.guardar(marketplace);
    }

    @PutMapping("/{id}")
    public FS_Marketplace editar(
            @PathVariable Integer id,
            @RequestBody FS_Marketplace marketplace
    ) {

        marketplace.setMarketplaceId(id);

        return service.guardar(marketplace);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        service.eliminar(id);
    }
}