import java.io.Serializable;

public class Persona implements Serializable {
    protected final static double SALARIO_DEF = 600;
    protected byte id; // 1 byte
    protected String nombre; // 2 bytes por carácer - 10 caracteres
    protected String apellido; // 2 bytes por carácer - 10 caracteres
    protected int edad; // 4 bytes
    protected double salario; //  8 bytes
    protected int numeroCervezas; // 4 bytes
    protected boolean juegaDardos; // 1 byte
    protected boolean tienePareja; // 1 byte

    // Total bytes= 59
    
    // Constructores
    // Constructor Canónico
    public Persona(String nombre, String apellido, int edad, double salario, int numeroCervezas, boolean juegaDardos,
            boolean tienePareja) {
        super();
        this.id=1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.numeroCervezas = numeroCervezas;
        this.juegaDardos = juegaDardos;
        this.tienePareja = tienePareja;
    }

    public Persona(String nombre, String apellido, int edad) {
        this(nombre, apellido, edad, SALARIO_DEF, 0, false, false);
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return String.format(
                "El tipo se llama %s, edad %d y lleva %d cervezas\n",
                this.nombre, this.edad, this.numeroCervezas);
    }

    public String getTodo(){
        return this.id + ","+this.nombre + ","+this.apellido+ ","+this.edad+ ","+this.salario+ ","+this.numeroCervezas+ ","+this.juegaDardos+ ","+this.tienePareja+ "\n";
    }
    public String getNombre() {
        return null;
    }

    public int getEdad() {
        return 0;
    }

    public String getApellido() {
        return null;
    }

    public int getNumeroCervezas() {
        return 0;
    }

    public boolean isTienePareja() {
        return false;
    }

    public double getSalario() {
        return 0;
    }

    public boolean isJuegaDardos() {
        return false;
    }

    public int getId() {
        return 0;
    }
}
