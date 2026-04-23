package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuthUsuario;
import com.example.demo.repository.AuthUsuarioRepository;

@Service
public class AuthUsuarioService {

    @Autowired
    private AuthUsuarioRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public List<AuthUsuario> listar() {
        return repository.findAll();
    }

    public Optional<AuthUsuario> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public AuthUsuario guardar(AuthUsuario usuario) {
        AuthUsuario anterior = null;
        String tipoEvento = "Registrar";

        try {
            if (usuario.getIdAuthUsuario() != null) {
                anterior = repository.findById(usuario.getIdAuthUsuario()).orElse(null);
                tipoEvento = "Editar";
            }

            AuthUsuario guardado = repository.save(usuario);

            bitacora.registrarEvento("AuthUsuarios", tipoEvento, "Proceso exitoso", anterior, guardado, null);

            return guardado;

        } catch (Exception e) {
            bitacora.registrarEvento("AuthUsuarios", "Error", "Error al guardar usuario", anterior, usuario, e);
            throw e;
        }
    }

    public void eliminar(Integer id) {
        AuthUsuario anterior = repository.findById(id).orElse(null);

        try {
            repository.deleteById(id);
            bitacora.registrarEvento("AuthUsuarios", "Eliminar", "Usuario eliminado", anterior, null, null);

        } catch (Exception e) {
            bitacora.registrarEvento("AuthUsuarios", "Error", "Error al eliminar usuario", anterior, null, e);
            throw e;
        }
    }
}