/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;

import dao.PeliculaDAO;
import dao.PeliculaDAOImpl;
import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author RS
 */
public class Test {

    public static void main(String[] args) {
        PeliculaDAO dao = new PeliculaDAOImpl();
        dao.agregar(new Pelicula ("chuky", "terror", 120, "www.chuky.pe", 2026, 18));
        //dao.listar();
        //dao.listar().forEach(System.out::println);
        //List<Pelicula> lista = dao.listar();

        //for (Pelicula pelicula : lista) {

           // System.out.println("id_pelicula:" + pelicula.getId_pelicula());

           // System.out.println("titulo:" + pelicula.getTitulo());

           // System.out.println("descripcion:" + pelicula.getDescripcion());

            //System.out.println("duracion:" + pelicula.getDuracion());

            //System.out.println("url_portada:" + pelicula.getUrl_portada());

            //System.out.println("anio:" + pelicula.getAño());

           // System.out.println("precio_alquiler:" + pelicula.getPrecio_alquiler());
            
            //System.out.println("==================");

       // }
       System.out.println("La pelicula encontrada es: "+dao.buscar(1));
       dao.eliminar(3);
       
    }
}
