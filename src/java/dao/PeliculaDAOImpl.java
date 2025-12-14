/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Pelicula;
import util.Conexion;


public class PeliculaDAOImpl implements PeliculaDAO {

    @Override
    public boolean agregar(Pelicula p) {

        String sql = "INSERT INTO PELICULA (titulo, descripcion, duracion, url_portada, anio, precio_alquiler) VALUES (?,?,?,?,?,?)";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getUrl_portada());
            ps.setInt(5, p.getAnio());
            ps.setDouble(6, p.getPrecio_alquiler());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error agregar: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Pelicula> listar() {

        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM PELICULA";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lista.add(new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("duracion"),
                        rs.getString("url_portada"),
                        rs.getInt("anio"),
                        rs.getDouble("precio_alquiler")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Pelicula buscar(int id) {

        String sql = "SELECT * FROM PELICULA WHERE id_pelicula=?";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("duracion"),
                        rs.getString("url_portada"),
                        rs.getInt("anio"),
                        rs.getDouble("precio_alquiler")
                );
            }
        } catch (Exception e) {
            System.out.println("Error buscar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Pelicula p) {

        String sql = "UPDATE PELICULA SET titulo=?, descripcion=?, duracion=?, url_portada=?, anio=?, precio_alquiler=? WHERE id_pelicula=?";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getUrl_portada());
            ps.setInt(5, p.getAnio());
            ps.setDouble(6, p.getPrecio_alquiler());
            ps.setInt(7, p.getId_pelicula());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM PELICULA WHERE id_pelicula=?";

        try (
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
        return false;
    }
}

