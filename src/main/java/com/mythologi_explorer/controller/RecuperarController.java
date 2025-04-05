package com.mythologi_explorer.controller;

import java.sql.SQLException;

import com.mythologi_explorer.controller.pantalla.PantallaController;
import com.mythologi_explorer.model.UsuarioManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class RecuperarController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonUsuario;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private Text textMensaje;
    @FXML
    private Button buttonEnviar;

    private UsuarioManager uManager;

    /**
     * Constructor general.
     * 
     * @throws SQLException error controlado.
     */
    public RecuperarController() throws SQLException {
        this.uManager = new UsuarioManager();
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
        pantallaIniciar(buttonUsuario);
    }

    /**
     * Recuperacion de cuenta.
     */
    @FXML
    public void buttonEnviarClick() {
        if (!validarCampos()) {
            textMensaje.setText("Credenciales null o vacias");
            return;
        }
        if (!uManager.recuperarCuenta(textFieldNombre.getText(), textFieldEmail.getText())) {
            textMensaje.setText("Credenciales incorrectas.");
            return;
        }
        textMensaje.setText("Credenciales correctas");
    }

    /**
     * Valida que los campos no sean null ni esten vacios.
     * 
     * @return retorna true si los campos fueron validados.
     */
    private boolean validarCampos() {
        return textFieldNombre != null && textFieldNombre.getText() != null && !textFieldNombre.getText().isBlank() &&
                textFieldEmail != null && textFieldEmail.getText() != null && !textFieldEmail.getText().isBlank();
    }

}