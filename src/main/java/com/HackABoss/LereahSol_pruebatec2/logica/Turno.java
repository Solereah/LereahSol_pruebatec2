
package com.HackABoss.LereahSol_pruebatec2.logica;

import java.util.Date;
import java.util.List;

public class Turno {
    
    private Long id;
    private List<Tramite> Tramite;
    private Date fecha;
    private List<Ciudadano> Ciudadano;

    public Turno() {
    }

    public Turno(Long id, List<Tramite> Tramite, Date fecha, List<Ciudadano> Ciudadano) {
        this.id = id;
        this.Tramite = Tramite;
        this.fecha = fecha;
        this.Ciudadano = Ciudadano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tramite> getTramite() {
        return Tramite;
    }

    public void setTramite(List<Tramite> Tramite) {
        this.Tramite = Tramite;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Ciudadano> getCiudadano() {
        return Ciudadano;
    }

    public void setCiudadano(List<Ciudadano> Ciudadano) {
        this.Ciudadano = Ciudadano;
    }


   

   
    
    
    
}
