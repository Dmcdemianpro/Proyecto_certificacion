package cl.proyecto.algoritmo;

import java.util.List;

import cl.proyecto.model.Pelicula;

public class DefaultMovieRatingCalculator implements MovieRatingCalculator {

    @Override
    public double calcularPromedioPonderado(Pelicula pelicula) {
        List<Integer> calificaciones = pelicula.getCalificaciones();
        int totalValoraciones = calificaciones.size();
        if (totalValoraciones == 0) {
            return 0.0;
        }

        int sumaValoraciones = 0;
        for (int valoracion : calificaciones) {
            sumaValoraciones += valoracion;
        }

        return (double) sumaValoraciones / totalValoraciones;
    }

    @Override
    public double calcularPromedioGeneral(Pelicula[] peliculas) {
        if (peliculas.length == 0) {
            return 0.0;
        }

        double sumaPromediosPonderados = 0.0;
        for (Pelicula pelicula : peliculas) {
            sumaPromediosPonderados += calcularPromedioPonderado(pelicula);
        }

        return sumaPromediosPonderados / peliculas.length;
    }
}
