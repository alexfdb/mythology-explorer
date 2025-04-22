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
        if(validarUsuario(usuario) == false) {
            return false;
        }
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
     * Elimina un usuario.
     * 
     * @param usuario usuario a eliminar.
     * @return retorna true si el usuario fue eliminado.
     */
    public boolean eliminarUsuario(Usuario usuario) {
        if(validarUsuario(usuario) == false) {
            return false;
        }
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

    /**
     * Buscar un usuario.
     * 
     * @param where where de la consulta sql.
     * @return retorna el usuario de la base de datos.
     */
    private Usuario buscarUsuario(String where) {
        String selectFrom = "SELECT nombre, contrasenia, email FROM usuario ";
        try (Connection connection = conectar();
                PreparedStatement preparedStatement = connection.prepareStatement(selectFrom + where)) {
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
    public Usuario buscarPorNombreYContrasenia(Usuario usuario) {
        if(validarUsuario(usuario) == false) {
            return null;
        }
        String where = "WHERE nombre = '" + usuario.getNombre() + "' AND contrasenia = '" + usuario.getContrasenia() + "'";
        return buscarUsuario(where);
    }

    /**
     * Busca un usuario por su email.
     * 
     * @param nombre nombre del usuario.
     * @param email  email del usuario.
     * @return retorna el usuario de la base de datos.
     */
    public Usuario buscarPorNombreYEmail(Usuario usuario) {
        if(validarUsuario(usuario) == false) {
            return null;
        }
        String where = "WHERE nombre = '" + usuario.getNombre() + "' AND email = '" + usuario.getEmail() + "'";
        return buscarUsuario(where);
    }

    /**
     * Validar usuario.
     * @param usuario usuario a validar.
     * @return retorna true si el usuario es valido.
     */
    private boolean validarUsuario(Usuario usuario) {
        if (usuario == null ||
                usuario.getNombre() == null || usuario.getNombre().isBlank() ||
                usuario.getContrasenia() == null || usuario.getContrasenia().isBlank() ||
                usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            return false;
        }
        return true;
    }

}