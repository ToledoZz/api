package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sinpe;
import com.example.demo.repository.SinpeRepository;

@Service
public class SinpeService {

    @Autowired
    private SinpeRepository repository;

    @Autowired
    private BitacoraService bitacora;

    // =========================
    // CRUD + BITACORA
    // =========================
    public List<Sinpe> listar(){
        return repository.findAll();
    }

    public Sinpe guardar(Sinpe sinpe){
        Sinpe anterior = null;
        String tipo = (sinpe.getIdSinpe() == null) ? "Registrar" : "Editar";
        
        try {
            if (sinpe.getIdSinpe() != null) {
                anterior = repository.findById(sinpe.getIdSinpe()).orElse(null);
            }
            Sinpe guardado = repository.save(sinpe);
            bitacora.registrarEvento("SINPE", tipo, "Transacción procesada", anterior, guardado, null);
            return guardado;
        } catch (Exception e) {
            bitacora.registrarEvento("SINPE", "Error", "Fallo al guardar", anterior, sinpe, e);
            throw e;
        }
    }

    public void eliminar(Integer id){
        Sinpe anterior = repository.findById(id).orElse(null);
        try {
            repository.deleteById(id);
            bitacora.registrarEvento("SINPE", "Eliminar", "ID: " + id, anterior, null, null);
        } catch (Exception e) {
            bitacora.registrarEvento("SINPE", "Error", "Fallo al eliminar", anterior, null, e);
            throw e;
        }
    }

    // 🔥 SINCRONIZAR + BITACORA
    public Sinpe sincronizar(Integer id){
        Sinpe anterior = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sinpe no encontrado"));

        try {
            // Creamos una copia para el registro antes de modificar
            Sinpe sinpe = repository.findById(id).get();
            sinpe.setEstado(true);
            Sinpe resultado = repository.save(sinpe);
            
            bitacora.registrarEvento("SINPE", "Editar", "Sincronización exitosa", anterior, resultado, null);
            return resultado;
        } catch (Exception e) {
            bitacora.registrarEvento("SINPE", "Error", "Fallo en sincronización", anterior, null, e);
            throw e;
        }
    }

    // =========================
    // CONSULTAS ORIGINALES (SIN CAMBIOS)
    // =========================
    
    // 🔥 NO SINCRONIZADOS
    public List<Sinpe> noSincronizados(){
        return repository.findByEstado(false);
    }

    // 🔥 FILTRO POR FECHA
    public List<Sinpe> porFecha(Date inicio, Date fin){
        return repository.findByFechaDeRegistroBetween(inicio, fin);
    }

    // 🔥 POR COMERCIO
    public List<Sinpe> porComercio(Integer idComercio){
        return repository.findByCaja_Comercio_IdComercio(idComercio);
    }

    // 🔥 POR COMERCIO Y FECHA
    public List<Sinpe> porComercioYFecha(Integer idComercio, Date inicio, Date fin){
        return repository.findByCaja_Comercio_IdComercioAndFechaDeRegistroBetween(
            idComercio, inicio, fin
        );
    }

    // 🔥 TOTAL GENERAL
    public Double totalGeneral(){
        return repository.findAll()
            .stream()
            .mapToDouble(s -> s.getMonto() != null ? s.getMonto() : 0)
            .sum();
    }

    // 🔥 TOTAL POR COMERCIO
    public Double totalPorComercio(Integer idComercio){
        return porComercio(idComercio)
            .stream()
            .mapToDouble(s -> s.getMonto() != null ? s.getMonto() : 0)
            .sum();
    }

    // 🔥 TOTAL POR FECHA
    public Double totalPorFecha(Date inicio, Date fin){
        return porFecha(inicio, fin)
            .stream()
            .mapToDouble(s -> s.getMonto() != null ? s.getMonto() : 0)
            .sum();
    }

    // 🔥 TOTAL POR COMERCIO Y FECHA
    public Double totalPorComercioYFecha(Integer idComercio, Date inicio, Date fin){
        return porComercioYFecha(idComercio, inicio, fin)
            .stream()
            .mapToDouble(s -> s.getMonto() != null ? s.getMonto() : 0)
            .sum();
    }

    // 🔥 CANTIDAD TOTAL
    public Long cantidadTotal(){
        return repository.count();
    }

    // 🔥 CANTIDAD POR COMERCIO
    public Long cantidadPorComercio(Integer idComercio){
        return (long) porComercio(idComercio).size();
    }

    // 🔥 CANTIDAD NO SINCRONIZADOS
    public Long cantidadNoSincronizados(){
        return repository.findByEstado(false).stream().count();
    }
}