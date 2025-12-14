/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.PeliculaDAO;
import dao.PeliculaDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author RS
 */
@WebServlet(name = "PeliculaDelete", urlPatterns = {"/PeliculaDelete"})
public class PeliculaDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
            System.out.println("Eliminar película ID: " + id_pelicula);

            PeliculaDAO dao = new PeliculaDAOImpl();
            dao.eliminar(id_pelicula);

        } catch (Exception e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
        }

        response.sendRedirect("PeliculaServlet");
    }
}
