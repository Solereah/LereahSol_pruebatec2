package com.HackABoss.LereahSol_pruebatec2.logica;

import com.HackABoss.LereahSol_pruebatec2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

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
        List<Ciudadano> listaCiuda = controlPersis.mostrarCiudadanos();
        List<Ciudadano> ciudaEncontrado = listaCiuda.stream()
                .filter(c -> c.getDni().equalsIgnoreCase(dni))
                .filter(c -> c.getApellido().equalsIgnoreCase(apellido))
                .toList();
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

}
