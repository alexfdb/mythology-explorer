package com.mythologi.explorer.controller;

import com.mythologi.explorer.controller.pantalla.PantallaController;
import com.mythologi.explorer.model.Usuario;
import com.mythologi.explorer.model.UsuarioManager;

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
        UsuarioManager usuarioManager = new UsuarioManager();
        Usuario usuarioDB = usuarioManager.buscarUsuarioPorEmail(textFieldNombre.getText(), textFieldEmail.getText());
        if (usuarioDB == null) {
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