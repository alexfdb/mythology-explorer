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

    private String databasePath;
    private File file;

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    protected DatabaseManager(String databasePathStr) {
        if(databasePathStr == null || databasePathStr.isBlank()) {
            return;
        }
        this.databasePath = databasePathStr;
        this.file = new File(databasePath);
        try {
            if (!file.exists()) {
                throw new SQLException("No existe la base de datos: " + databasePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea una conexion con la base de datos.
     * 
     * @return retorna la conexion con la base de datos.
     * @throws SQLException error controlado.
     */
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + databasePath);
    }

}