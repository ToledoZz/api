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

    // Listar todos los usuarios
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // Obtener por ID
    public Optional<Usuario> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    // Guardar o actualizar usuario
    public Usuario guardar(Usuario usuario) {
        // Validar identificación única
        Optional<Usuario> existente = repository.findByIdentificacion(usuario.getIdentificacion());
        if (existente.isPresent() && !existente.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new RuntimeException("Ya existe un usuario con esa identificación");
        }

        // Fecha de registro y estado por defecto
        if (usuario.getFechaDeRegistro() == null) {
            usuario.setFechaDeRegistro(new Date());
        }

        if (usuario.getEstado() == null) {
            usuario.setEstado(true); // Activo por defecto
        }

        // Fecha de modificación siempre actual
        usuario.setFechaDeModificacion(new Date());

        return repository.save(usuario);
    }

    // Eliminar usuario
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}