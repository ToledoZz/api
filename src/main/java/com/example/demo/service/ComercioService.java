package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Comercio;
import com.example.demo.repository.ComercioRepository;

@Service
public class ComercioService {

    @Autowired
    private ComercioRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<Comercio> listar() {
        return repository.findAll();
    }

    public Comercio guardar(Comercio comercio) {
        Comercio anterior = null;
        String tipoEvento = (comercio.getIdComercio() == null) ? "Registrar" : "Editar";
        
        try {
            if (comercio.getIdComercio() != null) {
                anterior = repository.findById(comercio.getIdComercio()).orElse(null);
            }
            Comercio guardado = repository.save(comercio);
            bitacora.registrarEvento("Comercios", tipoEvento, "Comercio procesado", anterior, guardado, null);
            return guardado;
        } catch (Exception e) {
            bitacora.registrarEvento("Comercios", "Error", null, anterior, comercio, e);
            throw e;
        }
    }

    public void eliminar(Integer id) {
        Comercio anterior = repository.findById(id).orElse(null);
        try {
            repository.deleteById(id);
            bitacora.registrarEvento("Comercios", "Eliminar", "ID: " + id, anterior, null, null);
        } catch (Exception e) {
            bitacora.registrarEvento("Comercios", "Error", "Fallo al eliminar", anterior, null, e);
            throw e;
        }
    }
}