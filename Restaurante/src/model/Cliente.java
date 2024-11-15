package model;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int idPedido;
    
    
    public Cliente(){}
    
    public Cliente(int id, String nombre, String apellido, int idPedido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idPedido = idPedido;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
       public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int pedido) {
        this.idPedido = pedido;
    }
}