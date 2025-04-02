package com.mythologi_explorer.controller;

import com.mythologi_explorer.controller.pantalla.PantallaController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class CrearController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    
    /**
     * Cambia a la pantalla de explorar.
     */
    @FXML
    public void buttonExplorarClick() {
        pantallaExplorar(buttonExplorar);
    }

}