package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_Likes")
public class FS_Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LikeId")
    private Integer likeId;

    @Column(name = "PublicacionId")
    private Integer publicacionId;

    @Column(name = "UsuarioId")
    private Integer usuarioId;

    @Column(name = "FechaLike")
    private Timestamp fechaLike;

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
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

    public Timestamp getFechaLike() {
        return fechaLike;
    }

    public void setFechaLike(Timestamp fechaLike) {
        this.fechaLike = fechaLike;
    }
}