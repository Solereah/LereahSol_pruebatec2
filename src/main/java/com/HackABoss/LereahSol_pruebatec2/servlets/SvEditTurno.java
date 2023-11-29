package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import com.HackABoss.LereahSol_pruebatec2.logica.Turno;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEditTurno", urlPatterns = {"/SvEditTurno"})
public class SvEditTurno extends HttpServlet {

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

        int idTurnoEdit = Integer.parseInt(request.getParameter("idTurnEdit"));

        Turno turnoEdit = control.traerTurno(idTurnoEdit);

        String nuevoEstado = request.getParameter("estado");
        System.out.println(nuevoEstado);
        
        turnoEdit.setEstado(nuevoEstado);
        control.editarTurno(turnoEdit);
        
       
        response.sendRedirect("mostrarTurnos.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
