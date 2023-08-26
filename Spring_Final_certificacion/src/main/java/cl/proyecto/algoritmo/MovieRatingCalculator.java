package cl.proyecto.algoritmo;

import cl.proyecto.model.Pelicula;

public interface MovieRatingCalculator {
    double calcularPromedioPonderado(Pelicula pelicula);
    double calcularPromedioGeneral(Pelicula[] peliculas);
}
