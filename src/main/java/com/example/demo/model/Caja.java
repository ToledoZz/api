package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cajas")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCaja")
    private Integer idCaja;

    @ManyToOne
    @JoinColumn(name = "ComercioId")
    private Comercio comercio;

    @Column(name = "MontoFinal")
    private Double montoFinal;

    @Column(name = "FechaApertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;

    @Column(name = "FechaCierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;

    @Column(name = "EstaAbierta")
    private Boolean estaAbierta;

    public Integer getIdCaja() { return idCaja; }
    public void setIdCaja(Integer idCaja) { this.idCaja = idCaja; }

    public Comercio getComercio() { return comercio; }
    public void setComercio(Comercio comercio) { this.comercio = comercio; }

    public Double getMontoFinal() { return montoFinal; }
    public void setMontoFinal(Double montoFinal) { this.montoFinal = montoFinal; }

    public Date getFechaApertura() { return fechaApertura; }
    public void setFechaApertura(Date fechaApertura) { this.fechaApertura = fechaApertura; }

    public Date getFechaCierre() { return fechaCierre; }
    public void setFechaCierre(Date fechaCierre) { this.fechaCierre = fechaCierre; }

    public Boolean getEstaAbierta() { return estaAbierta; }
    public void setEstaAbierta(Boolean estaAbierta) { this.estaAbierta = estaAbierta; }
}