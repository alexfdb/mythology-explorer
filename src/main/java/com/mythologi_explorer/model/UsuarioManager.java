package com.mythologi_explorer.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public UsuarioManager() throws SQLException {
        super();
    }

    /**
     * Obtiene un usuario a partir de una consulta.
     * 
     * @param query consulta de sql.
     * @return retorna el usuario si la consulta tiene exito.
     * @throws SQLException error controlado.
     */
    private Usuario obtenerUsuario(String query) throws SQLException {
        Usuario usuario = null;
        if (query == null) {
            return null;
        }
        try (PreparedStatement pStatement = conectar().prepareStatement(query);
                ResultSet rSet = pStatement.executeQuery();) {

            if (rSet.next()) {
                String nombre = rSet.getString("nombre");
                String contrasenia = rSet.getString("contrasenia");
                String email = rSet.getString("email");
                usuario = new Usuario(nombre, contrasenia, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
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
            pStatement.setString(3, usuario.getEmail());
            int rowsAffected = pStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Inicia la sesion del usuario.
     * 
     * @param nombre      nombre del usuario.
     * @param contrasenia contrasenia del usuario.
     * @return retorna true si el usuario inicio con exito.
     */
    public boolean iniciarSesion(String nombre, String contrasenia) {
        if (nombre == null || contrasenia == null) {
            return false;
        }
        String sql = "SELECT * FROM usuario WHERE nombre = ? AND contrasenia = ?";
        try (PreparedStatement pStatement = conectar().prepareStatement(sql)) {
            pStatement.setString(1, nombre);
            pStatement.setString(2, contrasenia);
            try (ResultSet rSet = pStatement.executeQuery()) {
                    return rSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}