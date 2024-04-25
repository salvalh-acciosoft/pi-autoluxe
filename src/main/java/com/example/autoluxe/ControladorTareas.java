package com.example.autoluxe;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class ControladorTareas
{
    @FXML
    private ImageView btnCerrarSesion;
    @FXML
    private Button btnAnadirTarea;
    @FXML
    private javafx.scene.control.Button btnEdicionTarea;

    @FXML
    private void cerrarVentana()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_InicioSesion.fxml"));
            Parent root = loader.load();
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            nuevaVentana.setScene(new Scene(root,1920,1080));
            Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            ventanaActual.close();
            nuevaVentana.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
