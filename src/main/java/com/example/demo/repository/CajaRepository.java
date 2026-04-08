package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Caja;

public interface CajaRepository extends JpaRepository<Caja, Integer> {
}