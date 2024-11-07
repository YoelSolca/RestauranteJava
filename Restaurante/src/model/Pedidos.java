package model;

public class Pedidos {
    private int id;
    private int id_salon;
    private int num_mesa;
    private String fecha;
    private double total;
    private String salon;
    private String usuario;
    private String estado;

    public Pedidos() {
    }

    public Pedidos(int id, int id_salon, int num_mesa, String fecha, double total, String salon, String usuario, String estado) {
        this.id = id;
        this.id_salon = id_salon;
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.total = total;
        this.salon = salon;
        this.usuario = usuario;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_salon() {
        return id_salon;
    }

    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
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

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
