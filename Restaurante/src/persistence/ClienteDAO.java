package persistence;

import model.Cliente;
import persistence.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    private Connection con;
    PreparedStatement ps;
    int r = 0;
    ResultSet rs;

    public ClienteDAO() {
        try {
            this.con = Conexion.getInstance().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public int IdPedido() {
        int id = 0;
        String query = "SELECT MAX(id) FROM pedidos";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    

    public int agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, id_pedido) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());       
            ps.setInt(3, cliente.getIdPedido());
            r = ps.executeUpdate();
            System.out.println("Cliente agregado correctamente con ID: " + cliente.getId());
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
        return r;
    }

    public Cliente obtenerCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("id_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cliente: " + e.getMessage());
        }
        return cliente;
    }

    public int modificarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre=?, apellido=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getId());
            r = ps.executeUpdate();
            System.out.println("Cliente con ID " + cliente.getId() + " modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        return r;
    }

    public int eliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            r = ps.executeUpdate();
            System.out.println("Cliente con ID " + id + " eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return r;
    }
}

