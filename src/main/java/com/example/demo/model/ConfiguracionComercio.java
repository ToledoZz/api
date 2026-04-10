package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ConfiguracionComercio")
public class ConfiguracionComercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdConfiguracion")
    private Integer idConfiguracion;

    @Column(name = "IdComercio")
    private Integer idComercio;

    @Column(name = "TipoConfiguracion")
    private Integer tipoConfiguracion;

    @Column(name = "Comision")
    private Integer comision;

    @Column(name = "FechaDeRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeRegistro;

    @Column(name = "FechaDeModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeModificacion;

    @Column(name = "Estado")
    private Boolean estado;

    // GETTERS Y SETTERS

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Integer getTipoConfiguracion() {
        return tipoConfiguracion;
    }

    public void setTipoConfiguracion(Integer tipoConfiguracion) {
        this.tipoConfiguracion = tipoConfiguracion;
    }

    public Integer getComision() {
        return comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(Date fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}