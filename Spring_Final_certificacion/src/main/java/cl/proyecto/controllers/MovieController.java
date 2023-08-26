package cl.proyecto.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.DAO.CalificacionDAO;
import cl.proyecto.DAO.GeneroDAO;
import cl.proyecto.DAO.PeliculaDAO;
import cl.proyecto.model.Calificacion;
import cl.proyecto.model.Genero;
import cl.proyecto.model.Pelicula;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peliculas")
public class MovieController {
    private final PeliculaDAO peliculaDAO;
    private final CalificacionDAO calificacionDAO;
    private final GeneroDAO generoDAO;

    @Autowired
    public MovieController(PeliculaDAO peliculaDAO, CalificacionDAO calificacionDAO, GeneroDAO generoDAO) {
        this.peliculaDAO = peliculaDAO;
        this.calificacionDAO = calificacionDAO;
        this.generoDAO = generoDAO;
    }

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaDAO.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable int id) {
        return peliculaDAO.findById(id);
    }

    @GetMapping("/{id}/calificaciones")
    public List<Calificacion> getCalificacionesByPelicula(@PathVariable int id) {
        return calificacionDAO.getCalificacionesByPelicula(id);
    }

    @GetMapping("/generos")
    public List<Genero> getAllGeneros() {
        return generoDAO.getAllGeneros();
    }
    

} 
