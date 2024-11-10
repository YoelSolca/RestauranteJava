package model;

public class Mesa {
    private int id;
    private String nombre;
    private int mesas;

    // Constructor vacío
    public Mesa() {
    }

    // Constructor con parámetros
    public Mesa(int id, String nombre, int mesas) {
        this.id = id;
        this.nombre = nombre;
        this.mesas = mesas;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        return "Mesa " + mesas; // Customize as needed
    }

}
