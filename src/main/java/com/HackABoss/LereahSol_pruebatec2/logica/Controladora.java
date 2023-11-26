
package com.HackABoss.LereahSol_pruebatec2.logica;

import com.HackABoss.LereahSol_pruebatec2.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
     //Ciudadano
    //Crear
    public void crearCiudadano(Ciudadano ciuda) {
        controlPersis.crearCiudadano(ciuda);
    }

    //Mostrar 1
    public Ciudadano MostrarCiudadano(Long id) {
        return controlPersis.MostrarCiudadano(id);
    }

    // Mostrar todos
    public List<Ciudadano> MostrarCiudadanos() {
        return controlPersis.MostrarCiudadanos();
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
    public void cancelarTurno(Long id){
      controlPersis.cancelarTurno(id);
    }
    
}
