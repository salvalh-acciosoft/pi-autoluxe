package ClasesObjetos;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;

public class BDautoluxe
{
    private String url="jdbc:mysql://roundhouse.proxy.rlwy.net:24175/railway";
    private String user="root";
    private String password="SeDNPlxucedhntNuhKnZYwEfzcgPtiGI";
    public static Connection connection=null;
    //Método para conectar con la base de datos
    public void conectar() throws SQLException, ClassNotFoundException
    {
        if (connection == null || connection.isClosed())
        {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("BD conectada");
        }
    }
    //Método para desconectar de la base de datos
    public void desconectar() throws SQLException
    {
        if (connection != null && !connection.isClosed())
        {
            connection.close();
            System.out.println("BD desconectada");
        }
    }
    //Método para obtener la conexión
    public Connection getConnection()
    {
        return connection;
    }
    //Método añadir empleados a la base de datos
    public static void altaEmpleadoBD(@NotNull Empleados empleado)
    {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("INSERT INTO empleados (DNI, nombre, apellidos, telefono, rol, correo, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)");

            st.setString(1, empleado.getDNI());
            st.setString(2, empleado.getNombre());
            st.setString(3, empleado.getApellidos());
            st.setString(4, empleado.getTelefono());
            st.setString(5, empleado.getRol());
            st.setString(6, empleado.getCorreo());
            st.setString(7, empleado.getContrasena());

            st.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Diálogo de Alerta");
            alert.setHeaderText("Empleado añadido.");
            alert.showAndWait();
        }
        catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Diálogo de Alerta");
            alert.setHeaderText("DNI existente");
            alert.showAndWait();
        }
    }
    //Método mostrar Empleados
    public static List<Empleados> listadoEmpleadosBD()
    {
        List<Empleados> listaVehiculos = FXCollections.observableArrayList();
        PreparedStatement st = null;
        ResultSet rs = null;
        try
        {
            st=connection.prepareStatement("SELECT * FROM empleados");

            rs=st.executeQuery();
            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String rol = rs.getString("rol");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contraseña");
                Empleados empleado = new Empleados(DNI, nombre, apellidos,telefono,rol,correo,contrasena);
                listaVehiculos.add(empleado);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return listaVehiculos;
    }
}
