package com.example.demo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.ConfiguracionComercio;
import com.example.demo.repository.ConfiguracionComercioRepository;

@Service
public class ConfiguracionComercioService {

    @Autowired
    private ConfiguracionComercioRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<ConfiguracionComercio> listar() {
        return repository.findAll();
    }

    public ConfiguracionComercio guardar(ConfiguracionComercio config) {
        try {
            if (repository.existsByIdComercio(config.getIdComercio())) {
                throw new RuntimeException("Ya existe configuración para este comercio");
            }
            config.setFechaDeRegistro(new Date());
            config.setEstado(true);

            ConfiguracionComercio guardada = repository.save(config);
            bitacora.registrarEvento("Configuracion", "Registrar", "Nueva config", null, guardada, null);
            return guardada;
        } catch (Exception e) {
            bitacora.registrarEvento("Configuracion", "Error", e.getMessage(), null, config, e);
            throw e;
        }
    }

    public ConfiguracionComercio editar(Integer id, ConfiguracionComercio config) {
        ConfiguracionComercio actual = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Configuración no encontrada"));
        ConfiguracionComercio copiaAnterior = actual; // Jackson capturará el estado actual

        try {
            actual.setTipoConfiguracion(config.getTipoConfiguracion());
            actual.setComision(config.getComision());
            actual.setEstado(config.getEstado());
            actual.setFechaDeModificacion(new Date());

            ConfiguracionComercio editada = repository.save(actual);
            bitacora.registrarEvento("Configuracion", "Editar", "Update config", copiaAnterior, editada, null);
            return editada;
        } catch (Exception e) {
            bitacora.registrarEvento("Configuracion", "Error", null, copiaAnterior, config, e);
            throw e;
        }
    }

    public ConfiguracionComercio obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}