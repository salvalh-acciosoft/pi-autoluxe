package ClasesObjetos;

public class Empleados
{
    protected String DNI;
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String rol;
    protected String correo;
    protected String contrasena;
    //Constructor
    public Empleados(String DNI,String nombre,String apellidos,String telefono,String rol,String correo,String contrasena)
    {
        this.DNI=DNI;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.telefono=telefono;
        this.rol=rol;
        this.correo=correo;
        this.contrasena=contrasena;
    }
    //Getters
    public String getDNI() {return DNI;}
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getTelefono() {return telefono;}
    public String getRol() {return rol;}
    public String getCorreo() {return correo;}
    public String getContrasena() {return contrasena;}
    //Setters
    public void setDNI(String DNI) {this.DNI = DNI;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setRol(String rol) {this.rol = rol;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
}
