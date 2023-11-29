package com.HackABoss.LereahSol_pruebatec2.servlets;

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

@WebServlet(name = "SvTurnosFiltrados", urlPatterns = {"/SvTurnosFiltrados"})
public class SvTurnosFiltrados extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Turno> turnosFiltrados = new ArrayList<>();

        String fechaInput = request.getParameter("inputDate");
        String estado = request.getParameter("estado");

        Date fecha = control.formatearFecha(fechaInput);

        System.out.println("estado es: " + estado);

        if (fecha != null && estado == null) {
            turnosFiltrados = control.filtrarPorFecha(fecha);
            System.out.println("Entre en filtro por fecha");
        }
        if (fechaInput != null && estado != null) {
            turnosFiltrados = control.filtrarPorFechaEstado(fecha, estado);
            System.out.println("Entre en filtro por fecha y estado");
        }

      
        //Con session
        HttpSession misession = request.getSession();
        misession.setAttribute("turnosFiltrados", turnosFiltrados);
        response.sendRedirect("mostrarTurnos.jsp");

        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
