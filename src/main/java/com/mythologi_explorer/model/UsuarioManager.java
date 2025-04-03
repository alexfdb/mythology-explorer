package com.mythologi_explorer.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    protected UsuarioManager() throws SQLException {
        super();
    }

    /**
     * Crea un nuevo usuario.
     * 
     * @param usuario usuario a crear.
     * @return retorna true si el usuario fue creado.
     */
    public boolean crearUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        String sql = "INSERT INTO usuario(nombre, contrasenia, email) VALUES (?, ?, ?)";
        try (PreparedStatement pStatement = conectar().prepareStatement(sql)) {
            pStatement.setString(1, usuario.getNombre());
            pStatement.setString(2, usuario.getContrasenia());
            pStatement.setString(3, usuario.getContrasenia());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}