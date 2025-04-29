package com.mythologi.explorer.controller;

import com.mythologi.explorer.controller.pantalla.PantallaController;
import com.mythologi.explorer.model.Usuario;
import com.mythologi.explorer.model.UsuarioManager;
import com.mythologi.explorer.model.sesion.Sesion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class IniciarController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonUsuario;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private PasswordField passwordFieldContrasenia;
    @FXML
    private Text textMensaje;
    @FXML
    private Button buttonEnviar;
    @FXML
    private Button buttonCrear;
    @FXML
    private Button buttonRecuperar;

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
        if(Sesion.getUsuarioActual() !=null) {
            pantallaPerfil(buttonUsuario);
        }
    }

    /**
     * Inicia sesion.
     */
    @FXML
    public void buttonEnviarClick() {
        if (!validarCampos()) {
            textMensaje.setText("Credenciales null o vacias");
            return;
        }
        UsuarioManager usuarioManager = new UsuarioManager();
        Usuario usuarioDB = usuarioManager.buscarUsuarioPorNombreYContrasenia(textFieldNombre.getText(), passwordFieldContrasenia.getText());
        if (usuarioDB == null) {
            textMensaje.setText("Credenciales incorrectas");
            return;
        }
        Sesion.iniciarSesion(usuarioDB);
        textMensaje.setText("");
        pantallaPerfil(buttonEnviar);
    }

    /**
     * Cambia a la pantalla de crear.
     */
    @FXML
    public void buttonCrearClick() {
        pantallaCrear(buttonCrear);
    }

    /**
     * Cambia a la pantalla de recuperar.
     */
    @FXML
    public void buttonRecuperarClick() {
        pantallaRecuperar(buttonRecuperar);
    }

    /**
     * Valida que los campos no sean null ni esten vacios.
     * 
     * @return retorna true si los campos son verificad.
     */
    private boolean validarCampos() {
        return textFieldNombre != null && textFieldNombre.getText() != null && !textFieldNombre.getText().isBlank() &&
                passwordFieldContrasenia.getText() != null && passwordFieldContrasenia != null
                && !passwordFieldContrasenia.getText().isBlank();
    }

}