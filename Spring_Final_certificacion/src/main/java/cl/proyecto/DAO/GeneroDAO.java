package cl.proyecto.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.proyecto.model.Genero;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GeneroDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GeneroDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Genero findById(int id_genero) {
        String query = "SELECT * FROM generos WHERE id_genero = ?";
        return jdbcTemplate.queryForObject(query, this::mapGenero, id_genero);
    }
   
    public Genero findByNombreGenero(String nombreGenero) {
        String query = "SELECT * FROM generos WHERE nombre_genero = ?";
        return jdbcTemplate.queryForObject(query, this::mapGenero, nombreGenero);
    }

    public List<Genero> getAllGeneros() {
        String query = "SELECT * FROM generos";
        return jdbcTemplate.query(query, this::mapGenero);
    }

    private Genero mapGenero(ResultSet resultSet, int rowNum) throws SQLException {
        Genero genero = new Genero();
        genero.setIdGenero(resultSet.getInt("id_genero"));
        genero.setNombreGenero(resultSet.getString("nombre_genero"));
        return genero;
    }

    
}
