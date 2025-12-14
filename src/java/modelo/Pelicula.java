/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author RS
 */
public class Pelicula {

    private int id_pelicula;
    private String titulo;
    private String descripcion;
    private int duracion;
    private String url_portada;
    private int anio;
    private double precio_alquiler;

    public Pelicula() {
    }

    public Pelicula(int id_pelicula, String titulo, String descripcion,
            int duracion, String url_portada, int anio, double precio_alquiler) {

        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.url_portada = url_portada;
        this.anio = anio;
        this.precio_alquiler = precio_alquiler;
    }
    
    public Pelicula( String titulo, String descripcion,
            int duracion, String url_portada, int anio, double precio_alquiler) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.url_portada = url_portada;
        this.anio = anio;
        this.precio_alquiler = precio_alquiler;
    }

    /**
     * @return the id_pelicula
     */
    public int getId_pelicula() {
        return id_pelicula;
    }

    /**
     * @param id_pelicula the id_pelicula to set
     */
    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the url_portada
     */
    public String getUrl_portada() {
        return url_portada;
    }

    /**
     * @param url_portada the url_portada to set
     */
    public void setUrl_portada(String url_portada) {
        this.url_portada = url_portada;
    }

    /**
     * @return the año
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param año the año to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the precio_alquiler
     */
    public double getPrecio_alquiler() {
        return precio_alquiler;
    }

    /**
     * @param precio_alquiler the precio_alquiler to set
     */
    public void setPrecio_alquiler(double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }
    
    @Override
    public String toString() {
        return id_pelicula+"|"+titulo+"|"+descripcion+"|"+duracion+"|"+url_portada+"|"+ anio+"|"+precio_alquiler;
    } 

}
