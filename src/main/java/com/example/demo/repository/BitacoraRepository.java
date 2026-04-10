package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BitacoraEvento;
import java.util.List;

public interface BitacoraRepository extends JpaRepository<BitacoraEvento, Integer> {
    // Listar filtrados por orden de fecha de registro 
    List<BitacoraEvento> findAllByOrderByFechaDeEventoDesc();
}