package cl.proyecto.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.proyecto.model.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PeliculaDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeliculaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pelicula> getAllPeliculas() {
        String query = "SELECT * FROM peliculas";
        return jdbcTemplate.query(query, this::mapPelicula);
    }

    public Pelicula findById(int id) {
        String query = "SELECT * FROM peliculas WHERE id_pelicula = ?";
        return jdbcTemplate.queryForObject(query, this::mapPelicula, id);
    }

    private Pelicula mapPelicula(ResultSet resultSet, int rowNum) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(resultSet.getInt("id_pelicula"));
        pelicula.setTitulo(resultSet.getString("titulo"));
        pelicula.setAnioLanzamiento(resultSet.getInt("anio_lanzamiento"));
        pelicula.setIdGenero(resultSet.getInt("id_genero"));
        return pelicula;
    }

    // Implementa otros métodos de acceso a la base de datos para películas
}
