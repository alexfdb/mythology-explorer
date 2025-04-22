package com.mythologi.explorer.controller;

import com.mythologi.explorer.controller.pantalla.PantallaController;
import com.mythologi.explorer.model.sesion.Sesion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
    private Text textMitologia;
    @FXML
    private Button buttonMitologia;
    @FXML
    private ImageView imageViewMitologia;
    @FXML
    private Text textDeidad;
    @FXML
    private Button buttonDeidad;
    @FXML
    private ImageView imageViewDeidad;
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonEliminarCuenta;

    @FXML
    public void buttonExplorarClick() {
        pantallaExplorar(buttonExplorar);
    }

    @FXML
    public void buttonMitologiaClick() {

    }

    @FXML
    public void buttonDeidadClick() {

    }

    @FXML
    public void buttonCerrarSesionClick() {
        Sesion.cerrarSesion();
        pantallaIniciar(buttonCerrarSesion);
    }

    @FXML
    public void buttonEliminarCuentaClick() {

    }

}