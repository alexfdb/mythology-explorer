package com.mythologi_explorer.controller;

import com.mythologi_explorer.controller.idioma.IdiomaController;
import com.mythologi_explorer.controller.pantalla.PantallaController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class ExplorarController extends PantallaController {

    @FXML
    private Button buttonIdioma;
    @FXML
    private Button buttonUsuario;
    @FXML
    private Text textExplorar;
    @FXML
    private Text textSumeria;
    @FXML
    private Text textEgipcia;

    private String idiomaActual = "es";

    /**
     * Cambia a la pantalla de explorar.
     */
    @FXML
    public void buttonIdiomaClick() {
        idiomaActual = idiomaActual.equals("es") ? "en" : "es";
        cambiarIdioma();
    }

    /**
     * Cambia a la pantalla de iniciar.
     */
    @FXML
    public void buttonUsuarioClick() {
        pantallaIniciar(buttonUsuario);
    }

    /**
     * Cambia el idioma de la aplicacion.
     */
    private void cambiarIdioma() {
        String path = "src/main/resources/view/idioma/" + idiomaActual + ".properties";
        IdiomaController.ConfigProperties.setPath(path);
        textExplorar.setText(IdiomaController.ConfigProperties.getProperties("textExplorar"));
        textSumeria.setText(IdiomaController.ConfigProperties.getProperties("textSumeria"));
        textEgipcia.setText(IdiomaController.ConfigProperties.getProperties("textEgipcia"));
    }

}