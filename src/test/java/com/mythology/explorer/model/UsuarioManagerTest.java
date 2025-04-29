package com.mythology.explorer.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mythologi.explorer.model.Usuario;
import com.mythologi.explorer.model.UsuarioManager;

/**
 * @author alexfdb
 * @version 1.0.0
 */
class UsuarioManagerTest {
    
        @Mock
        private Connection connection;
    
        @Mock
        private PreparedStatement preparedStatement;
    
        @Mock
        private ResultSet resultSet;
    
        private UsuarioManager usuarioManager;
    
        @BeforeEach
        void setUp() throws SQLException {
            MockitoAnnotations.initMocks(this);
            usuarioManager = mock(UsuarioManager.class, CALLS_REAL_METHODS);
            when(usuarioManager.conectar()).thenReturn(connection);
        }
    
        @Test
        void testCrearUsuario() throws SQLException {
            Usuario usuario = new Usuario("testUser", "testPassword", "test@example.com");
    
            String query = "INSERT INTO usuario(nombre, contrasenia, email) VALUES (?, ?, ?)";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeUpdate()).thenReturn(1);
    
            boolean result = usuarioManager.crearUsuario(usuario);
    
            assertTrue(result);
            verify(preparedStatement).setString(1, usuario.getNombre());
            verify(preparedStatement).setString(2, usuario.getContrasenia());
            verify(preparedStatement).setString(3, usuario.getEmail());
        }
    
        @Test
        void testBuscarUsuarioPorNombreYContrasenia() throws SQLException {
            Usuario usuario = new Usuario("testUser", "testPassword", null);
    
            String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND contrasenia = ?";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getString("nombre")).thenReturn("testUser");
            when(resultSet.getString("contrasenia")).thenReturn("testPassword");
            when(resultSet.getString("email")).thenReturn("test@example.com");
    
            Usuario result = usuarioManager.buscarUsuarioPorNombreYContrasenia("testUser", "testPassword");
    
            assertNotNull(result);
            assertEquals("testUser", result.getNombre());
            assertEquals("testPassword", result.getContrasenia());
            assertEquals("test@example.com", result.getEmail());
        }
    
        @Test
        void testBuscarUsuarioPorNombreYContrasenia_NoUsuario() throws SQLException {
            Usuario usuario = new Usuario("testUser", "wrongPassword", null);
    
            String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND contrasenia = ?";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(false);
    
            Usuario result = usuarioManager.buscarUsuarioPorNombreYContrasenia("testUser", "wrongPassword");
    
            assertNull(result);
        }
    
        @Test
        void testBuscarUsuarioPorEmail() throws SQLException {
            Usuario usuario = new Usuario("testUser", null, "test@example.com");
    
            String query = "SELECT nombre, contrasenia, email FROM usuario WHERE nombre = ? AND email = ?";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getString("nombre")).thenReturn("testUser");
            when(resultSet.getString("contrasenia")).thenReturn("testPassword");
            when(resultSet.getString("email")).thenReturn("test@example.com");
    
            Usuario result = usuarioManager.buscarUsuarioPorEmail("testUser", "test@example.com");
    
            assertNotNull(result);
            assertEquals("testUser", result.getNombre());
            assertEquals("testPassword", result.getContrasenia());
            assertEquals("test@example.com", result.getEmail());
        }
    
        @Test
        void testEliminarUsuario() throws SQLException {
            Usuario usuario = new Usuario("testUser", "testPassword", "test@example.com");
    
            String query = "DELETE FROM usuario WHERE nombre = ? AND contrasenia = ? AND email = ?";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeUpdate()).thenReturn(1);
    
            boolean result = usuarioManager.eliminarUsuario(usuario);
    
            assertTrue(result);
            verify(preparedStatement).setString(1, usuario.getNombre());
            verify(preparedStatement).setString(2, usuario.getContrasenia());
            verify(preparedStatement).setString(3, usuario.getEmail());
        }
    
        @Test
        void testEliminarUsuario_Failure() throws SQLException {
            Usuario usuario = new Usuario("testUser", "testPassword", "test@example.com");
    
            String query = "DELETE FROM usuario WHERE nombre = ? AND contrasenia = ? AND email = ?";
            when(connection.prepareStatement(query)).thenReturn(preparedStatement);
            when(preparedStatement.executeUpdate()).thenReturn(0);
    
            boolean result = usuarioManager.eliminarUsuario(usuario);
    
            assertFalse(result);
        }    

}