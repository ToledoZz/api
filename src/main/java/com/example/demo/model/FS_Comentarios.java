package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_Comentarios")
public class FS_Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComentarioId")
    private Integer comentarioId;

    @Column(name = "PublicacionId")
    private Integer publicacionId;

    @Column(name = "UsuarioId")
    private Integer usuarioId;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "FechaComentario")
    private Timestamp fechaComentario;

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer publicacionId) {
        this.publicacionId = publicacionId;
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

    public Timestamp getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Timestamp fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}