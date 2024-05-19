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
    //Método mostrar Empleados segun la opcion
    public static List<Empleados> listadoEmpleadosBD(String opcion, String busqueda)
    {
        List<Empleados> listaVehiculos = FXCollections.observableArrayList();
        PreparedStatement st = null;
        ResultSet rs = null;
        if(opcion=="Nombre")
        {
            try
            {
                st=connection.prepareStatement("SELECT * FROM empleados WHERE nombre='"+busqueda+"'");

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
        }
        else if(opcion=="Apellidos")
        {
            try
            {
                st=connection.prepareStatement("SELECT * FROM empleados WHERE apellidos='"+busqueda+"'");

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
        }
        else if(opcion=="Rol")
        {
            try
            {
                st=connection.prepareStatement("SELECT * FROM empleados WHERE rol='"+busqueda+"'");

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
        }
        else if(opcion=="DNI")
        {
            try
            {
                st=connection.prepareStatement("SELECT * FROM empleados WHERE DNI='"+busqueda+"'");

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
        }
        return listaVehiculos;
    }
    //Método para obtener un Empleado[DNI]
    public static Empleados obtenerEmpleadoDNI(String busqueda)
    {
        Empleados e = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try
        {
            st=connection.prepareStatement("SELECT * FROM empleados WHERE DNI='"+busqueda+"'");

            rs=st.executeQuery();
            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String rol = rs.getString("rol");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contraseña");
                e = new Empleados(DNI, nombre, apellidos,telefono,rol,correo,contrasena);
                
            }
        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }
        return e;
    }
    //Método para borrar un Empleado[DNI]
    public static void borrarEmpleadoBD(String busqueda)
    {
        PreparedStatement st = null;
        try
        {
            String query = "DELETE FROM empleados WHERE DNI=?";
            st = connection.prepareStatement(query);
            st.setString(1, busqueda);
            st.executeUpdate();
        }
        catch (SQLException i)
        {
            i.printStackTrace();
        }
    }
}
