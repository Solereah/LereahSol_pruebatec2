package com.HackABoss.LereahSol_pruebatec2.persistencia;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import com.HackABoss.LereahSol_pruebatec2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudaJPA = new CiudadanoJpaController();
    TurnoJpaController turnJPA = new TurnoJpaController();

    //Ciudadano
    //Crear
    public void crearCiudadano(Ciudadano ciuda) {
        ciudaJPA.create(ciuda);
    }

    //Mostrar 1
    public Ciudadano MostrarCiudadano(Long id) {
        return ciudaJPA.findCiudadano(id);
    }

    // Mostrar todos
    public List<Ciudadano> MostrarCiudadanos() {
        return ciudaJPA.findCiudadanoEntities();
    }

    //Turno 
    //Crear
    public void crearTurno(Turno nuevoTurno) {
        turnJPA.create(nuevoTurno);
    }
    //Mostrar 1 turno
    public Turno mostrarTurno(Long id) {
        return turnJPA.findTurno(id);
    }
    //Mostrar varios
    public List<Turno> mostrarTurnos() {
        return turnJPA.findTurnoEntities();

    }
    //Editar
    public void editarTurno(Turno turno) {
        try {
            turnJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Eliminar
    public void cancelarTurno(Long id){
        try {
            turnJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
