package com.mythologi.explorer.model;

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
    public UsuarioManager() throws SQLException {
        super();
    }

    /**
     * Comprueba si el usuario ya existe.
     * 
     * @param nombre nombre del usuario.
     * @param email  email del usuario.
     * @return retorna true si el usuario existe.
     */
    public boolean usuarioExistente(String nombre, String email) {
        if (nombre == null || email == null) {
            return false;
        }
        String query = "SELECT COUNT(id) FROM usuario WHERE nombre = ? AND email = ?";
        try (PreparedStatement pStatement = conectar().prepareStatement(query)) {
            pStatement.setString(1, nombre);
            pStatement.setString(2, email);
            try (ResultSet rSet = pStatement.executeQuery()) {
                return rSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        try (PreparedStatement pStatement = conectar().prepareStatement(query)) {
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
        String query = "SELECT id FROM usuario WHERE nombre = ? AND contrasenia = ?";
        try (PreparedStatement pStatement = conectar().prepareStatement(query)) {
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

    /**
     * Recupera la cuenta del usuario.
     * 
     * @param nombre nombre del usuario.
     * @param email  email del usuario.
     * @return retorna true si se envio la recuperacion de cuenta.
     */
    public boolean recuperarCuenta(String nombre, String email) {
        if (nombre == null || email == null) {
            return false;
        }
        String query = "SELECT id FROM usuario WHERE nombre = ? AND email = ?";
        try (PreparedStatement pStatement = conectar().prepareStatement(query)) {
            pStatement.setString(1, nombre);
            pStatement.setString(2, email);
            try (ResultSet rSet = pStatement.executeQuery()) {
                return rSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}