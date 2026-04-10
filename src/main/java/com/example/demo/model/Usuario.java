package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Integer idUsuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "IdComercio")
    private Comercio comercio;

    @Column(name = "IdNetUser")
    private String idNetUser;

    @NotNull
    @Column(name = "Nombres")
    private String nombres;

    @NotNull
    @Column(name = "PrimerApellido")
    private String primerApellido;

    @NotNull
    @Column(name = "SegundoApellido")
    private String segundoApellido;

    @NotNull
    @Column(name = "Identificacion", unique = true)
    private String identificacion;

    @NotNull
    @Column(name = "CorreoElectronico")
    private String correoElectronico;

    @Column(name = "FechaDeRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeRegistro;

    @Column(name = "FechaDeModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeModificacion;

    @Column(name = "Estado")
    private Boolean estado = true;

    // ===== GETTERS Y SETTERS =====
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public Comercio getComercio() { return comercio; }
    public void setComercio(Comercio comercio) { this.comercio = comercio; }

    public String getIdNetUser() { return idNetUser; }
    public void setIdNetUser(String idNetUser) { this.idNetUser = idNetUser; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public Date getFechaDeRegistro() { return fechaDeRegistro; }
    public void setFechaDeRegistro(Date fechaDeRegistro) { this.fechaDeRegistro = fechaDeRegistro; }

    public Date getFechaDeModificacion() { return fechaDeModificacion; }
    public void setFechaDeModificacion(Date fechaDeModificacion) { this.fechaDeModificacion = fechaDeModificacion; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}