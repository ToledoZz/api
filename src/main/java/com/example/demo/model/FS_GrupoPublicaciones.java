package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_GrupoPublicaciones")
public class FS_GrupoPublicaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GrupoPublicacionId")
    private Integer grupoPublicacionId;

    @Column(name = "GrupoId")
    private Integer grupoId;

    @Column(name = "UsuarioId")
    private Integer usuarioId;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "ImagenUrl")
    private String imagenUrl;

    @Column(name = "FechaPublicacion")
    private Timestamp fechaPublicacion;

    public Integer getGrupoPublicacionId() {
        return grupoPublicacionId;
    }

    public void setGrupoPublicacionId(Integer grupoPublicacionId) {
        this.grupoPublicacionId = grupoPublicacionId;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}