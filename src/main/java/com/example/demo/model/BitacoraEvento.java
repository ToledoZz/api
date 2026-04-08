package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bitacora_eventos")
public class BitacoraEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private Integer idEvento;

    @Column(name = "TablaDeEvento")
    private String tabla;

    @Column(name = "TipoDeEvento")
    private String tipo;

    @Column(name = "FechaDeEvento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "DescripcionDeEvento")
    private String descripcion;

    @Column(name = "StackTrace")
    private String stackTrace;

    @Column(name = "DatosAnteriores")
    private String datosAnteriores;

    @Column(name = "DatosPosteriores")
    private String datosPosteriores;

    // getters y setters
}