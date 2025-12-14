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
import modelo.Pelicula;

/**
 *
 * @author RS
 */
@WebServlet(name = "PeliculaEditServlet", urlPatterns = {"/PeliculaEditServlet"})
public class PeliculaEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
        System.out.println("se recibe el ID:"+ id_pelicula );
        
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        String url_portada = request.getParameter("url_portada");
        int anio = Integer.parseInt(request.getParameter("anio"));
        double precio_alquiler = Double.parseDouble(request.getParameter("precio_alquiler"));
        
        System.out.println("===== DATOS RECIBIDOS DEL EDIT =====");
    System.out.println("ID: " + id_pelicula);
    System.out.println("Titulo: " + titulo);
    System.out.println("Descripcion: " + descripcion);
    System.out.println("duracion: " + duracion);
    System.out.println("url: " + url_portada);
    System.out.println("Año: " + anio);
    System.out.println("precio: " + precio_alquiler);
    System.out.println("====================================");
    Pelicula actualizar= new Pelicula(id_pelicula,titulo,descripcion,duracion,url_portada, anio,precio_alquiler );
    PeliculaDAO dao= new PeliculaDAOImpl();
    dao.actualizar(actualizar);
    response.sendRedirect("PeliculaServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
