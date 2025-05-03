package com.mythologi.explorer.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.mythologi.explorer.controller.pantalla.PantallaController;
import com.mythologi.explorer.model.sesion.Sesion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class MitologiaController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonUsuario;
    @FXML
    private Text textMitologia;

    @FXML
    public void initialize() {
        String contenido = cargarTextoDesdeArchivo("/text/sumeria.txt");
        textMitologia.setText(contenido);
    }

    private String cargarTextoDesdeArchivo(String ruta) {
        StringBuilder texto = new StringBuilder();

        try (
                InputStream input = getClass().getResourceAsStream(ruta);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {

            String linea;
            boolean nuevoParrafo = true;

            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    texto.append("\n\n");
                    nuevoParrafo = true;
                } else {
                    if (nuevoParrafo) {
                        texto.append("    ");
                        nuevoParrafo = false;
                    }
                    texto.append(linea).append("\n");
                }
            }
        } catch (Exception e) {
            texto.append("No se pudo cargar el contenido.");
            e.printStackTrace();
        }

        return texto.toString();
    }

    /**
     * Cambia a la pantalla de explorar.
     */
    @FXML
    public void buttonExplorarClick() {
        pantallaExplorar(buttonExplorar);
    }

    /**
     * Cambia a la pantalla de iniciar.
     */
    @FXML
    public void buttonUsuarioClick() {
        if (Sesion.getUsuarioActual() != null) {
            pantallaPerfil(buttonUsuario);
            return;
        }
        pantallaIniciar(buttonUsuario);
    }

}