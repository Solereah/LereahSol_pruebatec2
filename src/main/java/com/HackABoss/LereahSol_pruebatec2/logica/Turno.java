package com.HackABoss.LereahSol_pruebatec2.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private List<String> tramites;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idTurno")
    private Ciudadano unCiudadano;

    public Turno() {
    }

    public Turno(Long idTurno, Date fecha, List<String> tramites, String estado, Ciudadano unCiudadano) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.tramites = new ArrayList<>();
        // Trámites por defecto
        this.tramites.add("Consumo");
        this.tramites.add("Contribuyente");
        this.tramites.add("Cultura");
        this.tramites.add("Empleo");
        this.tramites.add("Empadronamiento");
        this.tramites.add("Movilidad");
        this.tramites.add("Identificación Electrónica");
        this.tramites.add("Padrón y Censo");
        this.tramites.add("Protección Animal");
        this.tramites.add("Salud");
        this.tramites.add("Servicios Sociales");
        this.tramites.add("Urbanismo y Vivienda");
        this.estado = "En Espera";
        this.unCiudadano = unCiudadano;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getTramites() {
        return tramites;
    }

    public void setTramites(List<String> tramites) {
        this.tramites = tramites;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getUnCiudadano() {
        return unCiudadano;
    }

    public void setUnCiudadano(Ciudadano unCiudadano) {
        this.unCiudadano = unCiudadano;
    }

    
}
