package ClasesObjetos;

public class Productos {
    private String referencia;
    private int cantidad;
    private String descripcion;
    private String almacen;
    private double precio;

    public Productos(String referencia, int cantidad, String descripcion, String almacen, double precio) {
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.almacen = almacen;
        this.precio = precio;
    }

    // Getters y Setters

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}