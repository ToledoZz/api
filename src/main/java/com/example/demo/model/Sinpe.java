package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sinpes")
public class Sinpe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSinpe")
    private Integer idSinpe;

    @Column(name = "TelefonoOrigen")
    private String telefonoOrigen;

    @Column(name = "NombreOrigen")
    private String nombreOrigen;

    @Column(name = "TelefonoDestinatario")
    private String telefonoDestinatario;

    @Column(name = "NombreDestinatario")
    private String nombreDestinatario;

    @Column(name = "Monto")
    private Double monto;

    @Column(name = "FechaDeRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeRegistro;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "IdCaja")
    private Caja caja;

    public Integer getIdSinpe() { return idSinpe; }
    public void setIdSinpe(Integer idSinpe) { this.idSinpe = idSinpe; }

    public String getTelefonoOrigen() { return telefonoOrigen; }
    public void setTelefonoOrigen(String telefonoOrigen) { this.telefonoOrigen = telefonoOrigen; }

    public String getNombreOrigen() { return nombreOrigen; }
    public void setNombreOrigen(String nombreOrigen) { this.nombreOrigen = nombreOrigen; }

    public String getTelefonoDestinatario() { return telefonoDestinatario; }
    public void setTelefonoDestinatario(String telefonoDestinatario) { this.telefonoDestinatario = telefonoDestinatario; }

    public String getNombreDestinatario() { return nombreDestinatario; }
    public void setNombreDestinatario(String nombreDestinatario) { this.nombreDestinatario = nombreDestinatario; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public Date getFechaDeRegistro() { return fechaDeRegistro; }
    public void setFechaDeRegistro(Date fechaDeRegistro) { this.fechaDeRegistro = fechaDeRegistro; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public Caja getCaja() { return caja; }
    public void setCaja(Caja caja) { this.caja = caja; }
}