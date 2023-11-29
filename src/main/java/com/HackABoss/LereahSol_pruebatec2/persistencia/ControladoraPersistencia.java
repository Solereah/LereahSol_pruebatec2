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


    
    //-------------------CIUDADANOS------------------
  
    public void crearCiudadano(Ciudadano ciuda) {
        ciudaJPA.create(ciuda);
    }


    public Ciudadano traerCiudadano(int id) {
        return ciudaJPA.findCiudadano(id);
    }

 
    public List<Ciudadano> traerCiudadanos() {
        return ciudaJPA.findCiudadanoEntities();
    }

    //-------------------TURNOS-------------------
   
    public void crearTurno(Turno nuevoTurno) {
        turnJPA.create(nuevoTurno);
    }
 
    public Turno traerTurno(int id) {
        return turnJPA.findTurno(id);
    }
  
    public List<Turno> traerTurnos() {
        return turnJPA.findTurnoEntities();

    }

    public void editarTurno(Turno turno) {
        try {
            turnJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void eliminarTurno(int id){
        try {
            turnJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
