package com.mythologi_explorer.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mythologi_explorer.controller.pantalla.PantallaController;
import com.mythologi_explorer.model.Usuario;
import com.mythologi_explorer.model.UsuarioManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class CrearController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Button buttonUsuario;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldContrasenia;
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
    public CrearController() throws SQLException {
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
     * Ejecuta el boton enviar registrando un nuevo usuario.
     */
    @FXML
    public void buttonEnviarClick() {
        if (!validarCampos()) {
            textMensaje.setText("Credenciales null o vacias");
            return;
        }
        if (!validarEmail()) {
            textMensaje.setText("El formato del email es incorrecto");
            return;
        }
        Usuario usuario = new Usuario(textFieldNombre.getText(),
                textFieldContrasenia.getText(),
                textFieldEmail.getText());
        uManager.crearUsuario(usuario);
        textMensaje.setText("Usuario registrado con exito");
    }

    /**
     * Valida que los campos no sean null ni esten vacios.
     * 
     * @return retorna true si los campos fueron validados.
     */
    private boolean validarCampos() {
        return textFieldNombre != null && textFieldNombre.getText() != null && !textFieldNombre.getText().isBlank() &&
                textFieldContrasenia != null && textFieldContrasenia.getText() != null
                && !textFieldContrasenia.getText().isBlank() &&
                textFieldEmail != null && textFieldEmail.getText() != null && !textFieldEmail.getText().isBlank();
    }

    /**
     * Valida que el formato del email sea el correcto.
     * 
     * @return retorna true si el formato es correcto.
     */
    private boolean validarEmail() {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(textFieldEmail.getText());
        return matcher.matches();
    }

}