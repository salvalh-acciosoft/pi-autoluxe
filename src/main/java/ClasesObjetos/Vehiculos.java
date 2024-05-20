package ClasesObjetos;

public class Vehiculos {
    private String matricula;
    private String numBastidor;
    private String marca;
    private String modelo;
    private String combustible;
    private String color;
    private String DNI_cliente;

    // Constructor
    public Vehiculos(String matricula, String numBastidor, String marca, String modelo, String combustible, String color, String DNI_cliente) {
        this.matricula = matricula;
        this.numBastidor = numBastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.color = color;
        this.DNI_cliente = DNI_cliente;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getColor() {
        return color;
    }

    public String getDNI_cliente() {
        return DNI_cliente;
    }

    // Setters
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDNI_cliente(String DNI_cliente) {
        this.DNI_cliente = DNI_cliente;
    }
}
