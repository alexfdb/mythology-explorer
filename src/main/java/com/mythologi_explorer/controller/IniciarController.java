package com.mythologi_explorer.controller;

import com.mythologi_explorer.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IniciarController {
    
    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonCrear;

    /**
     * Cambia a la pantalla de explorar.
     */
    @FXML
    public void buttonExplorarClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/explorar.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 640);
            Stage stage = (Stage) buttonExplorar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Cambia a la pantalla de crear.
     */
    @FXML
    public void buttonCrearClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/crear.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 640);
            Stage stage = (Stage) buttonCrear.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}