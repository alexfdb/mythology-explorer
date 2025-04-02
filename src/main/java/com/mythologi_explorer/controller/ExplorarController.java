package com.mythologi_explorer.controller;

import com.mythologi_explorer.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExplorarController {

    @FXML
    private Button buttonUsuario;

    /**
     * Cambia a la pantalla de inicio.
     */
    @FXML
    public void buttonUsuarioClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/iniciar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 640);
            Stage stage = (Stage) buttonUsuario.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}