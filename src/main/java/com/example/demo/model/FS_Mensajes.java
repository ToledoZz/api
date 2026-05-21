package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_Mensajes")
public class FS_Mensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MensajeId")
    private Integer mensajeId;

    @Column(name = "EmisorId")
    private Integer emisorId;

    @Column(name = "ReceptorId")
    private Integer receptorId;

    @Column(name = "Mensaje")
    private String mensaje;

    @Column(name = "FechaMensaje")
    private Timestamp fechaMensaje;

    @Column(name = "Leido")
    private Boolean leido;

    public Integer getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Integer mensajeId) {
        this.mensajeId = mensajeId;
    }

    public Integer getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(Integer emisorId) {
        this.emisorId = emisorId;
    }

    public Integer getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(Integer receptorId) {
        this.receptorId = receptorId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Timestamp fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }
}