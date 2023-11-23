
package com.HackABoss.LereahSol_pruebatec2.logica;


public class Ciudadano {
    
    private Long id;
    private String nombre;
    private String Apellido;
    private String dni;
    private String telefono;
    private Turno turno;

    public Ciudadano() {
    }

    public Ciudadano(Long id, String nombre, String Apellido, String dni, String telefono, Turno turno) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
}
