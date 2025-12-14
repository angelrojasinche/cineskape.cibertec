/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.PeliculaDAO;
import dao.PeliculaDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author RS
 */
@WebServlet("/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PeliculaDAO dao = new PeliculaDAOImpl();
        req.setAttribute("ListaPelicula", dao.listar());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Pelicula p = new Pelicula(
                req.getParameter("titulo"),
                req.getParameter("descripcion"),
                Integer.parseInt(req.getParameter("duracion")),
                req.getParameter("url_portada"),
                Integer.parseInt(req.getParameter("anio")),
                Double.parseDouble(req.getParameter("precio_alquiler"))
        );

        new PeliculaDAOImpl().agregar(p);
        res.sendRedirect("PeliculaServlet");
    }
}

