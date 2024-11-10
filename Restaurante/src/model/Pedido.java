package model;

public class Pedido {
    private int id;
    private int idMesa;
    private String fecha;
    private double total;
    private String estado;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int id, int idMesa, String fecha, double total, String estado, String cliente) {
        this.id = id;
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.cliente = this.cliente;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idMesa=" + idMesa +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                '}';
    }
}
