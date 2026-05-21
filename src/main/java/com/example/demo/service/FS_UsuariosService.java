package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FS_Usuarios;
import com.example.demo.repository.FS_UsuariosRepository;

@Service
public class FS_UsuariosService {

    @Autowired
    private FS_UsuariosRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<FS_Usuarios> listar() {
        return repository.findAll();
    }

    public FS_Usuarios guardar(FS_Usuarios usuario) {

        FS_Usuarios anterior = null;

        String tipoEvento =
                (usuario.getUsuarioId() == null)
                ? "Registrar"
                : "Editar";

        try {

            if(usuario.getUsuarioId() != null) {
                anterior = repository.findById(usuario.getUsuarioId()).orElse(null);
            }

            FS_Usuarios guardado = repository.save(usuario);

            bitacora.registrarEvento(
                    "FS_Usuarios",
                    tipoEvento,
                    "Usuario procesado",
                    anterior,
                    guardado,
                    null
            );

            return guardado;

        } catch (Exception e) {

            bitacora.registrarEvento(
                    "FS_Usuarios",
                    "Error",
                    null,
                    anterior,
                    usuario,
                    e
            );

            throw e;
        }
    }

    public void eliminar(Integer id) {

        FS_Usuarios anterior = repository.findById(id).orElse(null);

        try {

            repository.deleteById(id);

            bitacora.registrarEvento(
                    "FS_Usuarios",
                    "Eliminar",
                    "ID: " + id,
                    anterior,
                    null,
                    null
            );

        } catch (Exception e) {

            bitacora.registrarEvento(
                    "FS_Usuarios",
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