package com.mythologi_explorer.model;

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
    private Connection connection;

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    protected DatabaseManager() throws SQLException {
        databasePath = "src/main/resources/view/data.db";
        file = new File(databasePath);
        try {
            if (!file.exists()) {
                throw new SQLException("No existe la base de datos: " + databasePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre la conexion a la base de datos.
     * 
     * @return retorna la conexion a la base de datos.
     */
    protected Connection conectar() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }

}