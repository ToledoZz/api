package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_Reportes")
public class FS_Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReporteId")
    private Integer reporteId;

    @Column(name = "UsuarioReportaId")
    private Integer usuarioReportaId;

    @Column(name = "UsuarioReportadoId")
    private Integer usuarioReportadoId;

    @Column(name = "PublicacionId")
    private Integer publicacionId;

    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "FechaReporte")
    private Timestamp fechaReporte;

    @Column(name = "Estado")
    private String estado;

    public Integer getReporteId() {
        return reporteId;
    }

    public void setReporteId(Integer reporteId) {
        this.reporteId = reporteId;
    }

    public Integer getUsuarioReportaId() {
        return usuarioReportaId;
    }

    public void setUsuarioReportaId(Integer usuarioReportaId) {
        this.usuarioReportaId = usuarioReportaId;
    }

    public Integer getUsuarioReportadoId() {
        return usuarioReportadoId;
    }

    public void setUsuarioReportadoId(Integer usuarioReportadoId) {
        this.usuarioReportadoId = usuarioReportadoId;
    }

    public Integer getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Integer publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Timestamp getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Timestamp fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}