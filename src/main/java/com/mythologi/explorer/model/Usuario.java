package com.mythologi.explorer.model;

import java.util.Objects;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Usuario {

    private String nombre;
    private String contrasenia;
    private String email;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor general.
     * 
     * @param nombre      nombre del usuario.
     * @param contrasenia contrasenia del usuario.
     * @param email       email del usuario.
     */
    public Usuario(String nombre, String contrasenia, String email) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return getNombre() + getContrasenia() + getEmail();
    }

}