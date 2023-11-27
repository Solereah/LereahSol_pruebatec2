package com.HackABoss.LereahSol_pruebatec2.logica;

import com.HackABoss.LereahSol_pruebatec2.persistencia.ControladoraPersistencia;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Ciudadano
    //Crear
    public void crearCiudadano(Ciudadano ciuda) {
        controlPersis.crearCiudadano(ciuda);
    }

    //Mostrar 1
    public Ciudadano mostrarCiudadano(Long id) {
        return controlPersis.mostrarCiudadano(id);
    }

    // Mostrar todos
    public List<Ciudadano> mostrarCiudadanos() {
        return controlPersis.mostrarCiudadanos();
    }

    public boolean ciudadanoExiste(String dni, String apellido) {
        boolean existe;
        List<Ciudadano> ciudaEncontrado = controlPersis.mostrarCiudadanos().stream()
                .filter(c -> c.getDni().equalsIgnoreCase(dni))
                .filter(c -> c.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList()); 
        existe = !ciudaEncontrado.isEmpty();
        return existe;
    }

    //Turno 
    //Crear
    public void crearTurno(Turno nuevoTurno) {
        controlPersis.crearTurno(nuevoTurno);
    }

    //Mostrar 1 turno
    public Turno mostrarTurno(Long id) {
        return controlPersis.mostrarTurno(id);
    }

    //Mostrar varios
    public List<Turno> mostrarTurnos() {
        return controlPersis.mostrarTurnos();

    }

    //Editar
    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }

    //Eliminar
    public void cancelarTurno(Long id) {
        controlPersis.cancelarTurno(id);
    }

    public List<Turno> filtrarTurnos(Date fecha, String estado) {

        List<Turno> turnosFiltrados = controlPersis.mostrarTurnos().stream()
                .filter(t -> t.getFecha().equals(fecha)) 
                .filter(t -> t.getEstado().equals(estado)) 
                .collect(Collectors.toList()); 
        return turnosFiltrados;

    }

}
