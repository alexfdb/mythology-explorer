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
    private Button buttonUsuario;

    /**
     * Cambia a la pantalla de inicio.
     */
    @FXML
    public void buttonUsuarioClick() {
        pantallaIniciar(buttonUsuario);
    }
    
}