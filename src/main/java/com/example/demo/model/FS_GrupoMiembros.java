package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_GrupoMiembros")
public class FS_GrupoMiembros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MiembroId")
    private Integer miembroId;

    @Column(name = "GrupoId")
    private Integer grupoId;

    @Column(name = "UsuarioId")
    private Integer usuarioId;

    @Column(name = "FechaUnion")
    private Timestamp fechaUnion;

    public Integer getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(Integer miembroId) {
        this.miembroId = miembroId;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Timestamp getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(Timestamp fechaUnion) {
        this.fechaUnion = fechaUnion;
    }
}