package com.example.autoluxe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.text.html.CSS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorTaller  implements Initializable
{
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Pane panelEditarElevador;
    //Botones para editar el estado de los elevadores
    @FXML
    private Button acElevador1;
    @FXML
    private Button acElevador2;
    @FXML
    private Button acElevador3;
    @FXML
    private Button acElevador4;
    @FXML
    private Button acElevador5;
    @FXML
    private Button acElevador6;
    //Botones de acciones de editar
    @FXML
    private Button acRevision;
    @FXML
    private Button acLiberar;
    @FXML
    private Button acOcupar;
    @FXML
    private Button acAccion;
    @FXML
    private Button acCancelar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnBuscar1;
    //TextField editar elevador
    @FXML
    private TextField buscar;
    @FXML
    private TextField buscar1;


    //Valores del panel editar elevador
    @FXML
    private TextField tvNumeroElevador;
    @FXML
    private TextField tvEstadoActual;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        acElevador1.setOnAction(event ->
        {
            abrirEditarElevador(1,acElevador1.getText());
        });
        acElevador2.setOnAction(event ->
        {
            abrirEditarElevador(2,acElevador2.getText());
        });
        acElevador3.setOnAction(event ->
        {
            abrirEditarElevador(3,acElevador3.getText());
        });
        acElevador4.setOnAction(event ->
        {
            abrirEditarElevador(4,acElevador4.getText());
        });
        acElevador5.setOnAction(event ->
        {
            abrirEditarElevador(5,acElevador5.getText());
        });
        acElevador6.setOnAction(event ->
        {
            abrirEditarElevador(6,acElevador6.getText());
        });
    }
    private void abrirEditarElevador(int elevador,String estado)
    {
        panelEditarElevador.setVisible(true);
        tvNumeroElevador.setText(String.valueOf(elevador));
        tvEstadoActual.setText(estado);
        acOcupar.setOnAction(event ->
        {
            if(elevador==1)
            {
                camposOcuparVisibles();
                camposOcuparOcultados1();
            }
            else if (elevador==2)
            {
                camposOcuparVisibles();
                camposOcuparOcultados2();
            }
            else if (elevador==3)
            {
                camposOcuparVisibles();
                camposOcuparOcultados3();
            }
            else if (elevador==4)
            {
                camposOcuparVisibles();
                camposOcuparOcultados4();
            }
            else if (elevador==5)
            {
                camposOcuparVisibles();
                camposOcuparOcultados5();
            }
            else if (elevador==6)
            {
                camposOcuparVisibles();
                camposOcuparOcultados6();
            }
        });
        acLiberar.setOnAction(event ->
        {
            if(elevador==1)
            {
                acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador1.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador1.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==2)
            {
                acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador2.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador2.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==3)
            {
                acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador3.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador3.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==4)
            {
                acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador4.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador4.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==5)
            {
                acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador5.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador5.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==6)
            {
                acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador6.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador6.setText("LIBRE");
                panelEditarElevador.setVisible(false);
            }
        });
        acRevision.setOnAction(event ->
        {
            if(elevador==1)
            {
                acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador1.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador1.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==2)
            {
                acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador2.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador2.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==3)
            {
                acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador3.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador3.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==4)
            {
                acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador4.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador4.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==5)
            {
                acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador5.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador5.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
            else if (elevador==6)
            {
                acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
                acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
                acElevador6.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
                acElevador6.setText("EN REVISIÓN");
                panelEditarElevador.setVisible(false);
            }
        });
    }
    private void camposOcuparVisibles()
    {
        acCancelar.setVisible(true);
        acAccion.setVisible(true);
        buscar.setVisible(true);
        buscar1.setVisible(true);
        btnBuscar.setVisible(true);
        btnBuscar1.setVisible(true);
    }
    private void camposOcuparOcultados1()
    {
        acAccion.setOnAction(event ->{
            acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
            acElevador1.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
            acElevador1.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
            acElevador1.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    private void camposOcuparOcultados2()
    {
        acAccion.setOnAction(event ->{
            acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
            acElevador2.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
            acElevador2.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
            acElevador2.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    private void camposOcuparOcultados3()
    {
        acAccion.setOnAction(event ->{
            acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
            acElevador3.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
            acElevador3.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
            acElevador3.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    private void camposOcuparOcultados4()
    {
        acAccion.setOnAction(event ->{
            acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
            acElevador4.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
            acElevador4.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
            acElevador4.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    private void camposOcuparOcultados5()
    {

            acAccion.setOnAction(event ->
            {
             acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
             acElevador5.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
             acElevador5.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
             acElevador5.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    private void camposOcuparOcultados6()
    {
        acAccion.setOnAction(event ->{
            acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_revision.css")));
            acElevador6.getStylesheets().remove(String.valueOf(getClass().getResource("/style/estilo_libre.css")));
            acElevador6.getStylesheets().add(String.valueOf(getClass().getResource("/style/estilo_ocupado.css")));
            acElevador6.setText("OCUPADO");
            acCancelar.setVisible(false);
            acAccion.setVisible(false);
            buscar.setVisible(false);
            buscar1.setVisible(false);
            btnBuscar.setVisible(false);
            btnBuscar1.setVisible(false);
            panelEditarElevador.setVisible(false);
        });
    }
    @FXML
    private void cerrarEditarElevador()
    {
        panelEditarElevador.setVisible(false);
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
        catch (IOException e)
        {
            e.printStackTrace();
        }
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
