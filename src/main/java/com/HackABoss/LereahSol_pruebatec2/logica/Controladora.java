package com.HackABoss.LereahSol_pruebatec2.logica;

import com.HackABoss.LereahSol_pruebatec2.persistencia.ControladoraPersistencia;
import com.HackABoss.LereahSol_pruebatec2.servlets.SvTurno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //-----------------------CIUDADANOS----------------------- 
    public void crearCiudadano(Ciudadano ciuda) {
        controlPersis.crearCiudadano(ciuda);
    }

    public Ciudadano traerCiudadano(int id) {
        return controlPersis.traerCiudadano(id);
    }

    public int obtenerIdCiudadano(String nombre, String apellido, String dni) {
        List<Ciudadano> ciudadanos = controlPersis.traerCiudadanos();

        for (Ciudadano ciudadano : ciudadanos) {
            if (ciudadano.getNombre().equalsIgnoreCase(nombre)
                    && ciudadano.getApellido().equalsIgnoreCase(apellido)
                    && ciudadano.getDni().equalsIgnoreCase(dni)) {
                return ciudadano.getIdCiudadano();
            }
        }
        return 0;

    }

    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadanos();
    }

    //-----------------------TURNOS----------------------- 
    public void crearTurno(Turno nuevoTurno) {
        controlPersis.crearTurno(nuevoTurno);
    }

    public Turno traerTurno(int id) {
        return controlPersis.traerTurno(id);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();

    }

    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }

    public void eliminarTurno(int id) {
        controlPersis.eliminarTurno(id);
    }

    //--------------------MÉTODOS--------------------
    public Date formatearFecha(String fechaInput) {
        if (fechaInput == null || fechaInput.isEmpty()) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fecha = sdf.parse(fechaInput);
            return fecha;
        } catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, "Error al parsear la fecha", ex);
            return null;

        }
    }

    public List<Turno> filtrarPorFecha(Date fecha) {

        return controlPersis.traerTurnos().stream()
                .filter(t -> t.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Turno> filtrarPorFechaEstado(Date fecha, String estado) {
        List<Turno> turnosFiltrados = filtrarPorFecha(fecha);

        turnosFiltrados = turnosFiltrados.stream()
                .filter(t -> t.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());

        return turnosFiltrados;
    }

// Expresión regular que permite letras con tildes y la letra 'ñ'
    public boolean validarNombreApellido(String texto) {

        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        return texto.matches(regex);
    }
    // Expresión regular que permite un DNI de 8 dígitos

    public boolean validarDNI(String dni) {
        String regex = "^[0-9]{8}$";
        return dni.matches(regex);
    }
// Expresión regular que permite un número de teléfono de 9 dígitos

    public boolean validarTelefono(String telefono) {

        String regex = "^[0-9]{9}$";
        return telefono.matches(regex);
    }

}
