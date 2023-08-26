package cl.proyecto.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.proyecto.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Usuario findById(int id) {
        String query = "SELECT * FROM usuarios WHERE id_usuario = ?";
        return jdbcTemplate.queryForObject(query, this::mapUsuario, id);
    }

    public Usuario findByNombreUsuario(String nombreUsuario) {
        String query = "SELECT * FROM usuarios WHERE nombreusuario = ?";
        return jdbcTemplate.queryForObject(query, this::mapUsuario, nombreUsuario);
    }

    public List<Usuario> getAllUsuarios() {
        String query = "SELECT * FROM usuarios";
        return jdbcTemplate.query(query, this::mapUsuario);
    }

    private Usuario mapUsuario(ResultSet resultSet, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getInt("id_usuario"));
        usuario.setNombreUsuario(resultSet.getString("nombreusuario"));
        usuario.setCorreoElectronico(resultSet.getString("correoelectronico"));
        usuario.setContrasena(resultSet.getString("contrasena"));
        return usuario;
    }

    // Implementa otros métodos de acceso a la base de datos para usuarios
}
