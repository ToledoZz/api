package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BITACORA_EVENTOS")
public class BitacoraEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private Integer idEvento;

    @Column(name = "TablaDeEvento", length = 20, nullable = false)
    private String tablaDeEvento;

    @Column(name = "TipoDeEvento", length = 20, nullable = false)
    private String tipoDeEvento;

    @Column(name = "FechaDeEvento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeEvento;

    @Column(name = "DescripcionDeEvento", columnDefinition = "TEXT", nullable = false)
    private String descripcionDeEvento;

    @Column(name = "StackTrace", columnDefinition = "TEXT", nullable = false)
    private String stackTrace;

    @Column(name = "DatosAnteriores", columnDefinition = "TEXT")
    private String datosAnteriores;

    @Column(name = "DatosPosteriores", columnDefinition = "TEXT")
    private String datosPosteriores;

    // Getters y Setters
    public Integer getIdEvento() { return idEvento; }
    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }
    public String getTablaDeEvento() { return tablaDeEvento; }
    public void setTablaDeEvento(String tablaDeEvento) { this.tablaDeEvento = tablaDeEvento; }
    public String getTipoDeEvento() { return tipoDeEvento; }
    public void setTipoDeEvento(String tipoDeEvento) { this.tipoDeEvento = tipoDeEvento; }
    public Date getFechaDeEvento() { return fechaDeEvento; }
    public void setFechaDeEvento(Date fechaDeEvento) { this.fechaDeEvento = fechaDeEvento; }
    public String getDescripcionDeEvento() { return descripcionDeEvento; }
    public void setDescripcionDeEvento(String descripcionDeEvento) { this.descripcionDeEvento = descripcionDeEvento; }
    public String getStackTrace() { return stackTrace; }
    public void setStackTrace(String stackTrace) { this.stackTrace = stackTrace; }
    public String getDatosAnteriores() { return datosAnteriores; }
    public void setDatosAnteriores(String datosAnteriores) { this.datosAnteriores = datosAnteriores; }
    public String getDatosPosteriores() { return datosPosteriores; }
    public void setDatosPosteriores(String datosPosteriores) { this.datosPosteriores = datosPosteriores; }
}