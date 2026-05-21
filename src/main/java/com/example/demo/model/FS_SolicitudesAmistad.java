package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_SolicitudesAmistad")
public class FS_SolicitudesAmistad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SolicitudId")
    private Integer solicitudId;

    @Column(name = "UsuarioEnviaId")
    private Integer usuarioEnviaId;

    @Column(name = "UsuarioRecibeId")
    private Integer usuarioRecibeId;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "FechaSolicitud")
    private Timestamp fechaSolicitud;

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getUsuarioEnviaId() {
        return usuarioEnviaId;
    }

    public void setUsuarioEnviaId(Integer usuarioEnviaId) {
        this.usuarioEnviaId = usuarioEnviaId;
    }

    public Integer getUsuarioRecibeId() {
        return usuarioRecibeId;
    }

    public void setUsuarioRecibeId(Integer usuarioRecibeId) {
        this.usuarioRecibeId = usuarioRecibeId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}