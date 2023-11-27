package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener la sesión
        HttpSession miSession = request.getSession(false);
        try {
            if (miSession != null) {
                // Obtener el Ciudadano de la sesión
                Ciudadano ciudadano = (Ciudadano) miSession.getAttribute("ciudadano");

                if (ciudadano != null) {
                    // Obtener otros datos del formulario
                    String fechaInput = request.getParameter("inputDate");
                    String tramite = request.getParameter("tipoTramite");
                    //formateo de fecha
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha= sdf.parse(fechaInput);
                    System.out.println(fecha);
                    // Crear un nuevo Turno y agregar datos del Ciudadano
                    Turno turno = new Turno();
                    turno.setFecha(fecha);
                    turno.setTramite(tramite);
                    turno.setEstado("En espera");
                    turno.setUnCiudadano(ciudadano);
                    
                 
                    control.crearTurno(turno);
                   request.getRequestDispatcher("index.jsp").forward(request, response);          
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
