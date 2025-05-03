package com.mythologi.explorer.controller;

import java.util.Optional;

import com.mythologi.explorer.controller.pantalla.PantallaController;
import com.mythologi.explorer.model.UsuarioManager;
import com.mythologi.explorer.model.sesion.Sesion;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class PerfilController extends PantallaController {

    @FXML
    private Button buttonExplorar;
    @FXML
    private Text textUsuario;
    @FXML
    private Text textEmail;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonEliminarCuenta;

    @FXML
    public void initialize() {
        textUsuario.setText(Sesion.getUsuarioActual().getNombre());
        textEmail.setText(Sesion.getUsuarioActual().getEmail());
    }

    @FXML
    public void buttonExplorarClick() {
        pantallaExplorar(buttonExplorar);
    }

    @FXML
    public void buttonCerrarSesionClick() {
        Sesion.cerrarSesion();
        pantallaIniciar(buttonCerrarSesion);
    }

    @FXML
    public void buttonEliminarCuentaClick() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmar eliminación");
        alerta.setHeaderText("¿Estás seguro de que deseas eliminar tu cuenta?");
        alerta.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            UsuarioManager usuarioManager = new UsuarioManager();
            usuarioManager.eliminarUsuario(Sesion.getUsuarioActual());
            pantallaIniciar(buttonEliminarCuenta);
        }
    }

}