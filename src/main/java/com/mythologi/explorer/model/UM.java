package com.mythologi.explorer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mythologi.explorer.model.database.DB;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class UM extends DB {

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    public UM() throws SQLException {
        super();
    }

    /**
     * Inserta un usuario en la base de datos.
     * 
     * @param usuario usuario a insertar.
     * @return retorna true si el usuario fue insertado.
     */
    public boolean insert(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        String query = "INSERT INTO usuario(nombre, contrasenia, email) VALUES (?, ?, ?)";
        try (Connection connection = crearConexion();
                PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
            pStatement.setString(3, usuario.getEmail());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Busca un usuario de la base de datos.
     * 
     * @param usuario usuario a buscar.
     * @return retorna el usuario buscado.
     */
    public Usuario read(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND contrasenia = ? AND email = ?";
        try (Connection connection = crearConexion();
                PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
            pStatement.setString(3, usuario.getEmail());
            try (ResultSet rSet = pStatement.executeQuery()) {
                if (rSet.next()) {
                    String nombre = rSet.getString("nombre");
                    String contrasenia = rSet.getString("contrasenia");
                    String email = rSet.getString("email");
                    return new Usuario(nombre, contrasenia, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza un usuario de la base de datos.
     * 
     * @param usuarioActual     usuario con los parametros actuales.
     * @param usuarioActualizar usuario con los parametros a actualizar.
     * @return retorna true si el usuario fue actualizado.
     */
    public boolean update(Usuario usuarioActual, Usuario usuarioActualizar) {
        if (usuarioActual == null || usuarioActualizar == null) {
            return false;
        }
        if (read(usuarioActual) == null) {
            return false;
        }
        String query = "UPDATE usuario SET nombre = ?, contrasenia = ?, email = ? WHERE nombre = ? AND contrasenia = ? AND email = ?";
        try (Connection connection = crearConexion();
                PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, usuarioActualizar.getNombre());
            pStatement.setString(2, usuarioActualizar.getContrasenia());
            pStatement.setString(3, usuarioActualizar.getEmail());
            pStatement.setString(4, usuarioActual.getNombre());
            pStatement.setString(5, usuarioActual.getContrasenia());
            pStatement.setString(6, usuarioActual.getEmail());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Elimina un usuario de la base de datos.
     * 
     * @param usuario usuario a eliminar.
     * @return retorna true si el usuario fue eliminado.
     */
    public boolean delete(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        String query = "DELETE FROM usuario WHERE nombre = ? AND contrasenia = ? AND email = ?";
        try (Connection connection = crearConexion();
                PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
            pStatement.setString(3, usuario.getEmail());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}