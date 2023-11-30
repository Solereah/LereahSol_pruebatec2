package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvCiudadano", urlPatterns = {"/SvCiudadano"})
public class SvCiudadano extends HttpServlet {

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

        String nombre = request.getParameter("inputNombre");
        String apellido = request.getParameter("inputApellido");
        String dni = request.getParameter("inputDNI");
        String tel = request.getParameter("inputTel");

        int idCiudaExist = control.obtenerIdCiudadano(nombre, apellido, dni);
        
        if (idCiudaExist != 0) {

            Ciudadano ciudaExistente = control.traerCiudadano(idCiudaExist);

            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("ciudadano", ciudaExistente);

        } else {
            Ciudadano nuevoCiuda = new Ciudadano();

            nuevoCiuda.setNombre(nombre);
            nuevoCiuda.setApellido(apellido);
            nuevoCiuda.setDni(dni);
            nuevoCiuda.setTelefono(tel);

            control.crearCiudadano(nuevoCiuda);

            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("ciudadano", nuevoCiuda);

        }

        response.sendRedirect("altaTurno.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
