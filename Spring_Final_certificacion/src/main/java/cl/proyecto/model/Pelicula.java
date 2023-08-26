package cl.proyecto.model;

import java.util.List;

public class Pelicula {
    private int idPelicula;
    private String titulo;
    private int anioLanzamiento;
    private int idGenero;
    
    private List<Integer> calificaciones;

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, int anioLanzamiento, int idGenero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.idGenero = idGenero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", idGenero=" + idGenero +
                '}';
    }

	

}
