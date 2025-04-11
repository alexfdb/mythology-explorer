package com.mythologi.explorer.model.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class DatabaseManager {

    private static final String DATABASE_PATH = "src/main/resources/view/data.db";
    private static final File FILE = new File(DATABASE_PATH);

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    protected DatabaseManager() throws SQLException {
        if (!FILE.exists()) {
            throw new SQLException("No existe la base de datos: " + DATABASE_PATH);
        }
    }

    /**
     * Crea una conexion con la base de datos.
     * 
     * @return retorna la conexion con la base de datos.
     * @throws SQLException error controlado.
     */
    protected Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DATABASE_PATH);
    }

}