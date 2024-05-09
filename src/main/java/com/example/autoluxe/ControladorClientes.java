package com.example.autoluxe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorClientes
{
    @FXML
    private AnchorPane contenedor;
    @FXML
    private ImageView btnCerrarSesion;
    //Panel añadir cliente
    @FXML
    private Pane panelCuerpo;
    //Panel editar cliente
    @FXML
    private Pane panelCuerpo1;
    //Panel añadir coche
    @FXML
    private Pane panelCuerpo2;
    //Panel editar coche
    @FXML
    private Pane panelCuerpo3;

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
    @FXML
    private void abrirAñadirCliente()
    {
        panelCuerpo.setVisible(true);
        panelCuerpo1.setVisible(false);
        panelCuerpo2.setVisible(false);
        panelCuerpo3.setVisible(false);
    }
    @FXML
    private void abrirEditarCliente()
    {
        panelCuerpo.setVisible(false);
        panelCuerpo1.setVisible(true);
        panelCuerpo2.setVisible(false);
        panelCuerpo3.setVisible(false);
    }
    @FXML
    private void abrirAñadirVehiculo()
    {
        panelCuerpo.setVisible(false);
        panelCuerpo1.setVisible(false);
        panelCuerpo2.setVisible(true);
        panelCuerpo3.setVisible(false);
    }
    @FXML
    private void abrirEditarVehiculo()
    {
        panelCuerpo.setVisible(false);
        panelCuerpo1.setVisible(false);
        panelCuerpo2.setVisible(false);
        panelCuerpo3.setVisible(true);
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
    @FXML
    private void abrirEmpleadosYRoles()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_empleadosyroles.fxml"));
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
    @FXML
    private void abrirInicio()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_inicio.fxml"));
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
    @FXML
    private void abrirClientes()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_clientes.fxml"));
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
    @FXML
    private void abrirFacturas()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_facturas.fxml"));
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
