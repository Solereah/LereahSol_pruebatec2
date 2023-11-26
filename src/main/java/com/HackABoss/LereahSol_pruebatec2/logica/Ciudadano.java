
package com.HackABoss.LereahSol_pruebatec2.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCiudadano;
    
    private String nombre;
    private String Apellido;
    private String dni;
    private String telefono;
    
    @OneToMany (mappedBy="unCiudadano")
    private List<Turno> turnos;

    public Ciudadano() {
    }

    public Ciudadano(Long idCiudadano, String nombre, String Apellido, String dni, String telefono, List<Turno> turnos) {
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.turnos = turnos;
    }

    public Long getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Long idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    
   
}
