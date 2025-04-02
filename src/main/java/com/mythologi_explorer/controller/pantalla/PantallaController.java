package com.mythologi_explorer.controller.pantalla;

import com.mythologi_explorer.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class PantallaController {

    /**
     * Cambia la pantalla por medio del boton a ejecutar y el path del fichero.
     * 
     * @param button   boton a ejectuar.
     * @param fxmlPath path del fichero.
     */
    private void cambiarPantalla(Button button, String fxmlPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), 360, 640);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Cambiar a la pantalla explorar.
     * 
     * @param button boton que ejecuta la pantalla.
     */
    protected void pantallaExplorar(Button button) {
        cambiarPantalla(button, "/view/explorar.fxml");
    }

    /**
     * Cambia a la pantalla iniciar.
     * 
     * @param button boton que ejecuta la pantalla.
     */
    protected void pantallaIniciar(Button button) {
        cambiarPantalla(button, "/view/iniciar.fxml");
    }

    /**
     * Cambiar a la pantalla crear.
     * 
     * @param button boton que ejecuta la pantalla.
     */
    protected void pantallaCrear(Button button) {
        cambiarPantalla(button, "/view/crear.fxml");
    }

    /**
     * Cambiar a la pantalla recuperar.
     * 
     * @param button boton que ejecuta la pantalla.
     */
    protected void pantallaRecuperar(Button button) {
        cambiarPantalla(button, "/view/recuperar.fxml");
    }

}