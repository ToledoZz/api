package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "AuthUsuarios")
public class AuthUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAuthUsuario")
    private Integer idAuthUsuario;

    @Column(name = "Correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "Rol", nullable = false)
    private String rol;

    @Column(name = "IdComercio", nullable = false)
    private Integer idComercio;

    // GETTERS & SETTERS

    public Integer getIdAuthUsuario() {
        return idAuthUsuario;
    }

    public void setIdAuthUsuario(Integer idAuthUsuario) {
        this.idAuthUsuario = idAuthUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }
}