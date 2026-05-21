package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Publicaciones;
import com.example.demo.repository.FS_PublicacionesRepository;

@Service
public class FS_PublicacionesService {

    @Autowired
    private FS_PublicacionesRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<FS_Publicaciones> listar() {
        return repository.findAll();
    }

    public FS_Publicaciones guardar(FS_Publicaciones publicacion) {

        FS_Publicaciones anterior = null;

        String tipoEvento =
                (publicacion.getPublicacionId() == null)
                ? "Registrar"
                : "Editar";

        try {

            if(publicacion.getPublicacionId() != null) {
                anterior = repository.findById(publicacion.getPublicacionId()).orElse(null);
            }

            FS_Publicaciones guardado = repository.save(publicacion);

            bitacora.registrarEvento(
                    "FS_Publicaciones",
                    tipoEvento,
                    "Publicación procesada",
                    anterior,
                    guardado,
                    null
            );

            return guardado;

        } catch (Exception e) {

            bitacora.registrarEvento(
                    "FS_Publicaciones",
                    "Error",
                    null,
                    anterior,
                    publicacion,
                    e
            );

            throw e;
        }
    }

    public void eliminar(Integer id) {

        FS_Publicaciones anterior = repository.findById(id).orElse(null);

        try {

            repository.deleteById(id);

            bitacora.registrarEvento(
                    "FS_Publicaciones",
                    "Eliminar",
                    "ID: " + id,
                    anterior,
                    null,
                    null
            );

        } catch (Exception e) {

            bitacora.registrarEvento(
                    "FS_Publicaciones",
                    "Error",
                    "Fallo al eliminar",
                    anterior,
                    null,
                    e
            );

            throw e;
        }
    }
}