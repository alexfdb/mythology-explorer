package com.mythologi.explorer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mythologi.explorer.model.database.DatabaseManager;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class UsuarioManager extends DatabaseManager {

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    public UsuarioManager() {
        super();
    }

    /**
     * Crea un usuario.
     * 
     * @param usuario usuario a crear.
     * @return retorna true si el usuario fue creado.
     */
    public boolean crearUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        String query = "INSERT INTO usuario(nombre, contrasenia, email) VALUES (?, ?, ?)";
        try (Connection connection = conectar();
                PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
            pStatement.setString(3, usuario.getEmail());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Buscar un usuario.
     * 
     * @param where where de la consulta sql.
     * @return retorna el usuario de la base de datos.
     */
    private Usuario buscarUsuario(String where) {
        String query = "SELECT nombre, contrasenia, email FROM usuario ";
        try (Connection connection = conectar();
                PreparedStatement preparedStatement = connection.prepareStatement(query + where)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombreStr = resultSet.getString("nombre");
                    String contraseniaStr = resultSet.getString("contrasenia");
                    String emailStr = resultSet.getString("email");
                    return new Usuario(nombreStr, contraseniaStr, emailStr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Busca un usuario por su nombre y contrasenia.
     * 
     * @param nombre      nombre del usuario.
     * @param contrasenia contrasenia del usuario.
     * @return retorna el usuario de la base de datos.
     */
    public Usuario buscarPorNombreYContrasenia(String nombre, String contrasenia) {
        String where = "WHERE nombre = '" + nombre + "' AND contrasenia = '" + contrasenia + "'";
        return buscarUsuario(where);
    }

    /**
     * Busca un usuario por su email.
     * 
     * @param nombre nombre del usuario.
     * @param email  email del usuario.
     * @return retorna el usuario de la base de datos.
     */
    public Usuario buscarPorNombreYEmail(String nombre, String email) {
        String where = "WHERE nombre = '" + nombre + "' AND email = '" + email + "'";
        return buscarUsuario(where);
    }

}