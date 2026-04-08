package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sinpe;

@Repository
public interface SinpeRepository extends JpaRepository<Sinpe, Integer> {

    List<Sinpe> findByEstado(Boolean estado);

    List<Sinpe> findByFechaDeRegistroBetween(Date inicio, Date fin);

    List<Sinpe> findByCaja_Comercio_IdComercio(Integer idComercio);

    List<Sinpe> findByCaja_Comercio_IdComercioAndFechaDeRegistroBetween(
        Integer idComercio, Date inicio, Date fin
    );
}