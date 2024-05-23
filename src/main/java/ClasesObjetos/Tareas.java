package ClasesObjetos;

public class Tareas
{
    protected int idTarea;
    protected String idEmpleado;
    protected String asunto;
    protected String descripcion;
    public Tareas(int idTarea,String idEmpleado, String asunto, String descripcion)
    {
        this.idTarea=idTarea;
        this.idEmpleado = idEmpleado;
        this.asunto = asunto;
        this.descripcion = descripcion;
    }

    public int getIdTarea() {return idTarea;}
    public String getIdEmpleado() {return idEmpleado;}
    public String getAsunto() {return asunto;}
    public String getDescripcion() {return descripcion;}
    public void setIdTarea(int idTarea) {this.idTarea = idTarea;}
    public void setIdEmpleado(String idEmpleado) {this.idEmpleado = idEmpleado;}
    public void setAsunto(String asunto) {this.asunto = asunto;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
