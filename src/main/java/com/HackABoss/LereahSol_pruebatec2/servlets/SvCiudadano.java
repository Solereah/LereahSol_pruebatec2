package com.HackABoss.LereahSol_pruebatec2.servlets;

import com.HackABoss.LereahSol_pruebatec2.logica.Ciudadano;
import com.HackABoss.LereahSol_pruebatec2.logica.Controladora;
import com.HackABoss.LereahSol_pruebatec2.logica.exceptions.DatosInvalidosException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        try {
            String nombre = request.getParameter("inputNombre");
            control.validarNombApe(nombre);

            String apellido = request.getParameter("inputApellido");
            control.validarNombApe(apellido);

            String dni = request.getParameter("inputDNI");
            control.validarDNI(dni);

            String tel = request.getParameter("inputTel");
            control.validarTelefono(tel);

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

        } catch (DatosInvalidosException e) {
            System.out.println("Los datos no son válidos. Por favor, vuelva a ingresarlos.");

            request.setAttribute("errorMensaje", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("datosInvalidos.jsp");
            dispatcher.forward(request, response);

        } catch (IOException e) {
          
            request.setAttribute("errorMensaje", "Error inesperado al procesar la solicitud.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("datosInvalidos.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
