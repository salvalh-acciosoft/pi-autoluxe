package com.example.autoluxe;

import ClasesObjetos.BDautoluxe;
import ClasesObjetos.Clientes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladorClientes implements Initializable {
    BDautoluxe bd = new BDautoluxe();
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

    // Panel añadir clientes
    // Campos cliente
    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfDNI;

    @FXML
    private TextField tfTelefono;

    @FXML
    private TextField tfCorreo;

    //Campos vehiculo
    @FXML
    private TextField tfMatricula;

    @FXML
    private TextField tfBastidor;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfColor;

    @FXML
    private TableView<Clientes> tablaCliente;

    @FXML
    private TableView<Clientes> tablaClientes;

    @FXML
    private TableColumn<Clientes, String> colApellidos;

    @FXML
    private TableColumn<Clientes, String> colApellidos1;

    @FXML
    private TableColumn<Clientes, String> colCorreo;

    @FXML
    private TableColumn<Clientes, String> colCorreo1;

    @FXML
    private TableColumn<Clientes, String> colDNI;

    @FXML
    private TableColumn<Clientes, String> colDNI1;

    @FXML
    private TableColumn<Clientes, String> colNombre;

    @FXML
    private TableColumn<Clientes, String> colNombre1;

    @FXML
    private TableColumn<Clientes, String> colTelefono;

    @FXML
    private TableColumn<Clientes, String> colTelefono1;

    @FXML
    private ChoiceBox<String> cbCombustible;
    private String[] tiposCombustibles = {"Gasolina", "Diesel"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            bd.conectar();

            cbCombustible.getItems().addAll(tiposCombustibles);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void introducirClienteBD() throws SQLException, ClassNotFoundException {
        System.out.println(tfNombre.getText());
        System.out.println(tfApellidos.getText());
        System.out.println(tfDNI.getText());
        System.out.println(tfTelefono.getText());
        System.out.println(tfCorreo.getText());

        if (tfNombre.getText().isEmpty() || tfDNI.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfCorreo.getText().isEmpty() || tfTelefono.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Por favor ingrese todos los campos.");
        } else {
            if (tfNombre.getText().length() > 25) {
                mostrarAlerta(Alert.AlertType.WARNING, "Exceso de caracteres en Nombre.");
            } else if (tfApellidos.getText().length() > 50) {
                mostrarAlerta(Alert.AlertType.WARNING, "Exceso de caracteres en Apellidos.");
            } else if (tfTelefono.getText().length() > 12) {
                mostrarAlerta(Alert.AlertType.WARNING, "Exceso de caracteres en Teléfono.");
            } else if (tfDNI.getText().length() != 9) {
                mostrarAlerta(Alert.AlertType.WARNING, "Número de caracteres", "El campo DNI debe de tener 9 caracteres.");
            } else if (!tfCorreo.getText().contains("@") || tfCorreo.getText().length() > 100) {
                mostrarAlerta(Alert.AlertType.WARNING, "Formato no válido", "El correo no contiene [@] o ha excedido de los 100 caracteres disponibles.");
            } else {
                if (!BDautoluxe.dniExisteCliente(tfDNI.getText()) && !BDautoluxe.correoExisteCliente(tfCorreo.getText())) {
                    Clientes cliente = new Clientes(tfDNI.getText(), tfNombre.getText(), tfApellidos.getText(), tfTelefono.getText(), tfCorreo.getText());
                    BDautoluxe.insertarCliente(cliente);
                    //establecerEmpleadoAnadido(empleado);
                    //establecerEmpleados();
                    //limpiarCampos();
                } else if (BDautoluxe.dniExisteEmpleado(tfDNI.getText())) {
                    mostrarAlerta(Alert.AlertType.WARNING, "DNI existente", "El DNI ingresado ya existe en la base de datos.");
                } else {
                    mostrarAlerta(Alert.AlertType.WARNING, "Correo existente", "El correo electrónico ingresado ya existe en la base de datos.");
                }
            }
        }
    }


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

    private void mostrarAlerta(Alert.AlertType tipo, String encabezado) {
        mostrarAlerta(tipo, encabezado, null);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String encabezado, String contenido) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Diálogo de Alerta");
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


}
