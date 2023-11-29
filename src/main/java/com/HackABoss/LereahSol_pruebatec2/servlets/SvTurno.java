package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

        List<Turno> listaTurnos = new ArrayList<>();
        listaTurnos = control.traerTurnos();
        
        //Filtro fechas y estado
        if (listaTurnos != null) {

            String fechaInput = request.getParameter("inputDate");
            String estado = request.getParameter("estado");

            Date fecha = control.formatearFecha(fechaInput);

            if (fechaInput != null && !fechaInput.isEmpty() && estado != null && !estado.isEmpty()) {
               
               listaTurnos =control.filtrarPorFechaEstado(fecha, estado);
            }else{
                listaTurnos = control.filtrarPorFecha(fecha);
              
            }
        }

        //Con session
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaTurnos", listaTurnos);
        response.sendRedirect("mostrarTurnos.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSession = request.getSession(false);
        try {

            if (miSession != null) {
                Ciudadano ciudadano = (Ciudadano) miSession.getAttribute("ciudadano");

                if (ciudadano != null) {
                    String fechaInput = request.getParameter("inputDate");
                    String tramite = request.getParameter("tipoTramite");

                    Date fecha = control.formatearFecha(fechaInput);

                    Turno turno = new Turno();

                    turno.setFecha(fecha);
                    turno.setTramite(tramite);
                    turno.setUnCiudadano(ciudadano);
                    turno.setEstado("En Espera");

                    control.crearTurno(turno);

                    response.sendRedirect("index.jsp");
                } else {
                    // Manejo si el ciudadano no está en la sesión
                    response.sendRedirect("error.jsp");
                }
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la creacion del turno" + e);
            response.sendRedirect("error.jsp");
        } finally {
            // Limpieza de la sesión
            miSession.invalidate();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
