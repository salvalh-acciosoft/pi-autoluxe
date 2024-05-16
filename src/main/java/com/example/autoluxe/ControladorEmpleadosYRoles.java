package com.example.autoluxe;

import ClasesObjetos.BDautoluxe;
import ClasesObjetos.Empleados;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorEmpleadosYRoles  {
    //Clase de la base de datos
    BDautoluxe bd = new BDautoluxe();
    //Paneles
    @FXML
    private AnchorPane contenedor;
    @FXML
    private Pane panelCuerpo1;
    //Botón barra superior
    @FXML
    private ImageView btnCerrarSesion;
    //Panel de Añadir Empleado
    @FXML
    private Pane panelCuerpo;
    @FXML
    private ChoiceBox<String> choiceBoxA;
    private String[] roles = {"Administrador", "Empleado: Mecánico", "Empleado: Chapa y Pintura","Empleado: Operador"};
    @FXML
    private TextField edNombreA;
    @FXML
    private TextField edDNIA;
    @FXML
    private TextField edApellidosA;
    @FXML
    private TextField edCorreoA;
    @FXML
    private TextField edTlfnoA;
    @FXML
    private PasswordField edContrasenaA;
    @FXML
    private TextField edBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private ChoiceBox<String> cbBusquedaEmpleadosA;
    private String[] opcionesBuscarEmpleado = {"DNI", "nombre","apellidos", "rol"};
    //Tabla Buscar Empleados
    @FXML
    private TableView<Empleados> vistaEmpleadosA;
    @FXML
    private TableColumn<Empleados, String> colDNIEmpleadoA;
    @FXML
    private TableColumn<Empleados, String> colNombreEmpleadoA;
    @FXML
    private TableColumn<Empleados, String> colApellidosEmpleadoA;
    @FXML
    private TableColumn<Empleados, String> colRolEmpleadoA;
    @FXML
    private TableColumn<Empleados, String> colCorreoEmpleadoA;
    @FXML
    private TableColumn<Empleados, String> colTelefonoEmpleadoA;
    //Tabla Empleado Añadido

    public void initialize() throws SQLException, ClassNotFoundException {
        //Aplicamos la lista al ChoiceBox
        choiceBoxA.getItems().addAll(roles);
        choiceBoxA.getSelectionModel().select(1);
        //Aplicamos la lista al ChoiceBox
        cbBusquedaEmpleadosA.getItems().addAll(opcionesBuscarEmpleado);
        cbBusquedaEmpleadosA.getSelectionModel().select(0);
        //Aplicamos la lista de todos los empleados en la Tabla Empleados
        establecerEmpleados();
        iniciarColumnas();
    }
    @FXML
    private void cerrarVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_InicioSesion.fxml"));
            Parent root = loader.load();
            contenedor.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirAñadirEmpleados()
    {
        panelCuerpo.setVisible(true);
        panelCuerpo1.setVisible(false);
    }
    @FXML
    private void abrirEditarEmpleados()
    {
        panelCuerpo.setVisible(false);
        panelCuerpo1.setVisible(true);
    }
    @FXML
    private void introducirEmpleadoBD() throws SQLException, ClassNotFoundException {
        bd.conectar();
        if(edNombreA.getText().isEmpty()||edDNIA.getText().isEmpty()||edApellidosA.getText().isEmpty()||edCorreoA.getText().isEmpty()||edContrasenaA.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Diálogo de Alerta");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor ingrese todos los campos.");
            alert.showAndWait();
        }
        else
        {
            if(edNombreA.getText().length()>25)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Exceso de caracteres en Nombre.");
                alert.showAndWait();
            }
            else if(edApellidosA.getText().length()>50)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Exceso de caracteres en Apellidos.");
                alert.showAndWait();
            }
            else if(edTlfnoA.getText().length()>12)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Exceso de caracteres en Teléfono.");
                alert.showAndWait();
            }
            if(edDNIA.getText().length()!=9)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Número de caracteres");
                alert.setContentText("El campo DNI debe de tener 9 caracteres.");
                alert.showAndWait();
            }
            else if(edContrasenaA.getText().length()<8||edContrasenaA.getText().length()>50)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Contraseña poca segura");
                alert.setContentText("La contraseña tiene que tener más de 8 caracteres y menos de 50.");
                alert.showAndWait();
            }
            else if (edCorreoA.getText().contains("@autoluxe.com")==false||edCorreoA.getText().length()>100)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Diálogo de Alerta");
                alert.setHeaderText("Formato no válido");
                alert.setContentText("El correo no tiene las credenciales de AutoLuxe [@autoluxe.com] o ha excedido de los 100 caracteres disponibles.");
                alert.showAndWait();
            }
            else
            {
                Empleados empleado=new Empleados(edDNIA.getText(),edNombreA.getText(),edApellidosA.getText(),edTlfnoA.getText(),cbBusquedaEmpleadosA.getValue().toString(),edCorreoA.getText(),edContrasenaA.getText());
                BDautoluxe.altaEmpleadoBD(empleado);
            }
        }
        bd.desconectar();
    }
    public void establecerEmpleados() throws SQLException, ClassNotFoundException {
        bd.conectar();
        List<Empleados> listaEmpleados=BDautoluxe.listadoEmpleadosBD();
        vistaEmpleadosA.setItems((ObservableList<Empleados>) listaEmpleados);
        bd.desconectar();
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
    private void iniciarColumnas()
    {
        colDNIEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("DNI"));
        colNombreEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("nombre"));
        colApellidosEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("apellidos"));
        colRolEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("rol"));
        colCorreoEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("correo"));
        colTelefonoEmpleadoA.setCellValueFactory(new PropertyValueFactory<Empleados,String>("telefono"));
    }
}
