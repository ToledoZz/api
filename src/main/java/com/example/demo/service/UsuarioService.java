package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BitacoraService bitacora;

    public Usuario guardar(Usuario usuario) {
        Usuario anterior = null;
        String tipo = (usuario.getIdUsuario() == null) ? "Registrar" : "Editar";

        try {
            if (usuario.getIdUsuario() != null) {
                anterior = repository.findById(usuario.getIdUsuario()).orElse(null);
            }

            Optional<Usuario> existente = repository.findByIdentificacion(usuario.getIdentificacion());
            if (existente.isPresent() && !existente.get().getIdUsuario().equals(usuario.getIdUsuario())) {
                throw new RuntimeException("Ya existe un usuario con esa identificación");
            }

            if (usuario.getFechaDeRegistro() == null) usuario.setFechaDeRegistro(new Date());
            if (usuario.getEstado() == null) usuario.setEstado(true);
            usuario.setFechaDeModificacion(new Date());

            Usuario guardado = repository.save(usuario);
            bitacora.registrarEvento("Usuarios", tipo, "Usuario guardado", anterior, guardado, null);
            return guardado;

        } catch (Exception e) {
            bitacora.registrarEvento("Usuarios", "Error", e.getMessage(), anterior, usuario, e);
            throw e;
        }
    }

    public void eliminar(Integer id) {
        Usuario anterior = repository.findById(id).orElse(null);
        try {
            repository.deleteById(id);
            bitacora.registrarEvento("Usuarios", "Eliminar", "Usuario borrado", anterior, null, null);
        } catch (Exception e) {
            bitacora.registrarEvento("Usuarios", "Error", null, anterior, null, e);
            throw e;
        }
    }

    public List<Usuario> listar() { return repository.findAll(); }
    public Optional<Usuario> obtenerPorId(Integer id) { return repository.findById(id); }
}