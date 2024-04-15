package com.example.autoluxe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControladorInicioSesion {
    @FXML
    private TextField edEmail;

    @FXML
    private TextField edContraseña;

    @FXML
    private Button bt1;
    @FXML
    private Label msgError2;
    @FXML
    private Label msgError1;

    @FXML
    private void accionBt1() throws IOException {
        msgError1.setVisible(false);
        msgError2.setVisible(false);
        if(edEmail.getText().isEmpty()||edContraseña.getText().isEmpty()||edEmail.getText().contains("@")==false)
        {
            if (edEmail.getText().isEmpty()||edEmail.getText().contains("@")==false)
            {
                msgError1.setVisible(true);
            }
            if(edContraseña.getText().isEmpty())
            {
                msgError2.setVisible(true);
            }
        }
        else
        {
            abrirAplicacion();
        }

    }
    @FXML
    private void abrirAplicacion() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
            Parent root = loader.load();
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            nuevaVentana.setScene(new Scene(root));
            Stage ventanaActual = (Stage) bt1.getScene().getWindow();
            ventanaActual.close();
            nuevaVentana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirGmail()
    {
        String url = "https://www.google.com/intl/es/gmail/about/";
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirInstagram()
    {
        String url = "https://www.instagram.com/auto_luxe_js/";
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void abrirFacebook()
    {
        String url = "https://www.facebook.com/profile.php?id=61558487721041";
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}