package com.example.autoluxe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPerfil implements Initializable {
    @FXML
    private AnchorPane contenedor;

    // Imagen
    @FXML
    private ImageView iconoSetting;

    // Label
    @FXML
    private Label lblNombre;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblDNI;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblROL;

    // Paneles
    @FXML
    private Pane panelCuenta;

    @FXML
    private Pane panelCuenta2;

    // Botones
    @FXML
    private ImageView btnCerrarSesion;


    @FXML
    private void abrirMiCuenta() {
        panelCuenta.setVisible(true);
        panelCuenta2.setVisible(false);

    }

    @FXML
    private void abrirEditarCuenta() {
        panelCuenta.setVisible(false);
        panelCuenta2.setVisible(true);

    }

    @FXML
    private void cerrarVentana()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_InicioSesion.fxml"));
            Parent root = loader.load();
//          Stage nuevaVentana = new Stage();
//          nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
//          nuevaVentana.setScene(new Scene(root,1920,1000));
//          Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
//          ventanaActual.close();
//          nuevaVentana.show();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panelCuenta.setVisible(true);
        panelCuenta2.setVisible(false);
    }
    /*
    MENU 7/8
     */
    @FXML
    private void abrirTareas()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_tareas.fxml"));
            Parent root = loader.load();
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root,1920,1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root,1920,1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root,1920,1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root,1920,1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root,1920,1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
            //Stage nuevaVentana = new Stage();
            //nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
            //nuevaVentana.setScene(new Scene(root, 1920, 1000));
            //Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
            //ventanaActual.close();
            //nuevaVentana.show();
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
//            Stage nuevaVentana = new Stage();
//            nuevaVentana.setTitle("AutoLuxe"); // Puedes establecer el título
//            nuevaVentana.setScene(new Scene(root,1920,1000));
//            Stage ventanaActual = (Stage) btnCerrarSesion.getScene().getWindow();
//            ventanaActual.close();
//            nuevaVentana.show();
            contenedor.getChildren().setAll(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
