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


    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadanos();
    }

 
    public boolean ciudadanoExiste(String dni, String apellido) {
        boolean existe;
        List<Ciudadano> ciudaEncontrado = controlPersis.traerCiudadanos().stream()
                .filter(c -> c.getDni().equalsIgnoreCase(dni))
                .filter(c -> c.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
        existe = !ciudaEncontrado.isEmpty();
        return existe;
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
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = sdf.parse(fechaInput);
            return fecha;
            
        } catch (ParseException ex) {
        Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, "Error al parsear la fecha", ex);
 
        }
        return null;
    }
   
 
    public List<Turno> filtrarPorFecha(Date fecha) {

        return  controlPersis.traerTurnos().stream()
                .filter(t -> t.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
    public List<Turno> filtrarPorFechaEstado(Date fecha, String estado) {

        List<Turno> turnosFiltrados = filtrarPorFecha(fecha);
        turnosFiltrados.stream()
                .filter(t -> t.getEstado().equals(estado))
                .collect(Collectors.toList());
        return turnosFiltrados;
    }

}
