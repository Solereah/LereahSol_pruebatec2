package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
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
        try {
            HttpSession miSession = request.getSession(false);

            if (miSession != null) {
                Ciudadano ciudadano = (Ciudadano) miSession.getAttribute("ciudadano");

                if (ciudadano != null) {
                    String fechaInput = request.getParameter("inputDate");
                    String tramite = request.getParameter("tipoTramite");

                    // Manejo de formato de fecha
                    Date fecha = null;
                    fecha = control.formatearFecha(fechaInput);

                    Turno turno = new Turno();
                    turno.setFecha(fecha);
                    turno.setTramite(tramite);
                    turno.setEstado("En Espera");
                    turno.setUnCiudadano(ciudadano);

                    control.crearTurno(turno);

                    response.sendRedirect("index.jsp");
                } else {
                    // Manejo si el ciudadano no está en la sesión
                    response.sendRedirect("error.jsp");
                }
            }
        } catch (IOException e) {

            response.sendRedirect("error.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
