package com.mythologi_explorer.controller;

import com.mythologi_explorer.controller.pantalla.PantallaController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class ExplorarController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonUsuario;

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
        pantallaIniciar(buttonUsuario);
    }

}