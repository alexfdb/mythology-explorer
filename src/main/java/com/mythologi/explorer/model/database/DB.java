package com.mythologi.explorer.model.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class DB {

    private static final String DB_PATH = "src/main/resources/view/data.db";
    private static final File FILE = new File(DB_PATH);

    /**
     * Constructor general.
     * 
     * @throws SQLException
     */
    protected DB() throws SQLException {
        if (!FILE.exists() || !FILE.isFile()) {
            throw new SQLException("No existe la base de datos " + DB_PATH);
        }
    }

    /**
     * Crea una conexion con la base de datos.
     * 
     * @return retorna la conexion creada.
     * @throws SQLException error controlado.
     */
    protected Connection crearConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
    }

}