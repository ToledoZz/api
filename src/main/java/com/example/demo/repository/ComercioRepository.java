package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Comercio;

public interface ComercioRepository extends JpaRepository<Comercio, Integer> {

}