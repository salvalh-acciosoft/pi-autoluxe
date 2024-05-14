package com.example.autoluxe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorFacturas
{
    @FXML
    private AnchorPane contenedor;
    @FXML
    private ImageView btnCerrarSesion;
    @FXML
    private void cerrarVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_InicioSesion.fxml"));
            Parent root = loader.load();
//            Stage nuevaVentana = new Stage();
//            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
//            nuevaVentana.setScene(new Scene(root, 1920, 1000));
//            Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
//            ventanaActual.close();
//            nuevaVentana.show();
            contenedor.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    MENU 8/8
     */
    @FXML
    private void abrirTareas()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_tareas.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirEmpleadosYRoles()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_empleadosyroles.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirInicio()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_inicio.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirClientes()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_clientes.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirFacturas()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_facturas.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirPerfil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_perfil.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTaller()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_taller.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirServicios()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_servicios.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
