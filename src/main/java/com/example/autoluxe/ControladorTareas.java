package com.example.autoluxe;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class ControladorTareas
{
    @FXML
    private ImageView btnCerrarSesion;
    @FXML
    private Button btnAnadirTarea;
    @FXML
    private javafx.scene.control.Button btnEdicionTarea;
    //Panel de Añadir Tarea
    @FXML
    private Pane panelCuerpo;
    //Panel de Editar Tarea
    private Pane panelCuerpo1;

    @FXML
    private void cerrarVentana()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_InicioSesion.fxml"));
            Parent root = loader.load();
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            nuevaVentana.setScene(new Scene(root,1920,1000));
            Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            ventanaActual.close();
            nuevaVentana.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirAñadirTarea()
    {
        panelCuerpo.setVisible(true);
    }
    @FXML
    private void abrirEditarTarea()
    {
        panelCuerpo.setVisible(false);
    }
    /*
    MENU 1/6
     */
    @FXML
    private void abrirTareas()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_tareas.fxml"));
            Parent root = loader.load();
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            nuevaVentana.setScene(new Scene(root,1920,1000));
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
