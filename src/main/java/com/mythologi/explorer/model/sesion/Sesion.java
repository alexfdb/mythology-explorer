package com.mythologi.explorer.model.sesion;

import com.mythologi.explorer.model.Usuario;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Sesion {

    private static Usuario usuarioActual = null;

    /**
     * Constructor privado.
     */
    private Sesion() {
    }

    /**
     * Mantiene un usuario en sesion.
     * 
     * @param usuario usuario a iniciar.
     */
    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    /**
     * Cierra la sesion del usuario.
     */
    public static void cerrarSesion() {
        usuarioActual = null;
    }

    /**
     * Muestra el usuario actual.
     * 
     * @return retorna el usuario acual.
     */
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

}