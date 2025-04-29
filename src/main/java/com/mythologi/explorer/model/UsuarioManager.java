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
        super("src/main/resources/db/data.db");
    }

    /**
     * Crea un usuario.
     * 
     * @param usuario usuario a crear.
     * @return retorna true si el usuario fue creado.
     */
    public boolean crearUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario(nombre, contrasenia, email) VALUES (?, ?, ?)";
        try (Connection connection = conectar();
                PreparedStatement preparedStatment = connection.prepareStatement(query)) {
            preparedStatment.setString(1, usuario.getNombre());
            preparedStatment.setString(2, usuario.getContrasenia());
            preparedStatment.setString(3, usuario.getEmail());
            return preparedStatment.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Buscar un usuario por su nombre y su contrasenia.
     * 
     * @return retorna el usuario de la base de datos.
     */
    public Usuario buscarUsuarioPorNombreYContrasenia(String nombre, String contrasenia) {
        String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND contrasenia = ?";
        try (Connection connection = conectar();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, contrasenia);
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
     * Buscar un usuario por su nombre y su email.
     * 
     * @return retorna el usuario de la base de datos.
     */
    public Usuario buscarUsuarioPorEmail(String nombre, String email) {
        String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND email = ?";
        try (Connection connection = conectar();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
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
     * Elimina un usuario.
     * 
     * @param usuario usuario a eliminar.
     * @return retorna true si el usuario fue eliminado.
     */
    public boolean eliminarUsuario(Usuario usuario) {
        String query = "DELETE FROM usuario WHERE nombre = ? AND contrasenia = ? AND email = ?";
        try (Connection connection = conectar();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getContrasenia());
            preparedStatement.setString(3, usuario.getEmail());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}