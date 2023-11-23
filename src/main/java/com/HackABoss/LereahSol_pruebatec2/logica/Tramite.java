
package com.HackABoss.LereahSol_pruebatec2.logica;


public class Tramite {
    private Long id;
    private String descripcion;
    private Turno turno;

    public Tramite() {
    }

    public Tramite(Long id, String descripcion, Turno turno) {
        this.id = id;
        this.descripcion = descripcion;
        this.turno = turno;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
}
