package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AuthUsuario;

public interface AuthUsuarioRepository extends JpaRepository<AuthUsuario, Integer> {

    Optional<AuthUsuario> findByCorreo(String correo);
}