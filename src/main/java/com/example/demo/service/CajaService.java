package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Caja;
import com.example.demo.repository.CajaRepository;

@Service
public class CajaService {

    @Autowired
    private CajaRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<Caja> listar() {
        return repository.findAll();
    }

    public Caja guardar(Caja caja) {
        Caja anterior = null;
        String tipoEvento = "Registrar";

        try {
            if (caja.getIdCaja() != null) {
                anterior = repository.findById(caja.getIdCaja()).orElse(null);
                tipoEvento = "Editar";
            }
            
            Caja guardada = repository.save(caja);
            bitacora.registrarEvento("Cajas", tipoEvento, "Proceso exitoso", anterior, guardada, null);
            return guardada;
        } catch (Exception e) {
            bitacora.registrarEvento("Cajas", "Error", "Error al guardar caja", anterior, caja, e);
            throw e;
        }
    }

    public void eliminar(Integer id) {
        Caja anterior = repository.findById(id).orElse(null);
        try {
            repository.deleteById(id);
            bitacora.registrarEvento("Cajas", "Eliminar", "Caja eliminada", anterior, null, null);
        } catch (Exception e) {
            bitacora.registrarEvento("Cajas", "Error", "Error al eliminar caja", anterior, null, e);
            throw e;
        }
    }

    public Optional<Caja> obtenerPorId(Integer id) {
        return repository.findById(id);
    }
}