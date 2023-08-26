package cl.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Calificacion {
    private int id_Calificacion;
    private int id_Pelicula;
    private int id_Usuario;
    private int puntuacion;
    private String resena;

    public Calificacion() {
    }

    public Calificacion(int idCalificacion, int idPelicula, int idUsuario, int puntuacion, String resena) {
        this.id_Calificacion = idCalificacion;
        this.id_Pelicula = idPelicula;
        this.id_Usuario = idUsuario;
        this.puntuacion = puntuacion;
        this.resena = resena;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_Calificacion() {
        return id_Calificacion;
    }

    public void setId_Calificacion(int idCalificacion) {
        this.id_Calificacion = idCalificacion;
    }

    public int getId_Pelicula() {
        return id_Pelicula;
    }

    public void setId_Pelicula(int idPelicula) {
        this.id_Pelicula = idPelicula;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int idUsuario) {
        this.id_Usuario = idUsuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }
}

