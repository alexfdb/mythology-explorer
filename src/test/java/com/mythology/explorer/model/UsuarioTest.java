package com.mythology.explorer.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mythologi.explorer.model.Usuario;

/**
 * @author alexfdb
 * @version 1.0.0
 */
class UsuarioTest {

    @Test
    void testConstructorYGetters() {
        String nombre = "Juan";
        String contrasenia = "secreta123";
        String email = "juan@example.com";
        
        Usuario usuario = new Usuario(nombre, contrasenia, email);
        
        assertEquals(nombre, usuario.getNombre());
        assertEquals(contrasenia, usuario.getContrasenia());
        assertEquals(email, usuario.getEmail());
    }

    @Test
    void testEquals() {
        Usuario usuario1 = new Usuario("Juan", "secreta123", "juan@example.com");
        Usuario usuario2 = new Usuario("Juanito", "otro123", "juan@example.com");

        assertTrue(usuario1.equals(usuario2));
    }

    @Test
    void testNotEquals() {
        Usuario usuario1 = new Usuario("Juan", "secreta123", "juan@example.com");
        Usuario usuario2 = new Usuario("Carlos", "password123", "carlos@example.com");

        assertFalse(usuario1.equals(usuario2));
    }

    @Test
    void testHashCode() {
        Usuario usuario1 = new Usuario("Juan", "secreta123", "juan@example.com");
        Usuario usuario2 = new Usuario("Juanito", "otro123", "juan@example.com");

        assertEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    void testToString() {
        String nombre = "Juan";
        String contrasenia = "secreta123";
        String email = "juan@example.com";
        
        Usuario usuario = new Usuario(nombre, contrasenia, email);
        
        assertEquals(nombre + contrasenia + email, usuario.toString());
    }
}
