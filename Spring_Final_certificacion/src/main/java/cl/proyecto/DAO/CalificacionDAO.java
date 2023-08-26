package cl.proyecto.DAO;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.proyecto.model.Calificacion;

import java.util.List;

@Repository
public class CalificacionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CalificacionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Calificacion> getCalificacionesByPelicula(int id_Pelicula) {
        String query = "SELECT * FROM calificaciones WHERE id_pelicula = ?";
        return jdbcTemplate.query(query, new Object[]{id_Pelicula}, new BeanPropertyRowMapper<>(Calificacion.class));
    }

    public void deleteCalificacion(int id_Calificacion) {
        String query = "DELETE FROM calificaciones WHERE id = ?";
        jdbcTemplate.update(query, id_Calificacion);
    }
}