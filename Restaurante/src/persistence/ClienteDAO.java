package persistence;

import model.Cliente;
import java.sql.*;

public class ClienteDAO {
    private Connection con;
    PreparedStatement ps;
    int r = 0;

    public ClienteDAO() {
        try {
            this.con = Conexion.getInstance().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        }
    }

    public int agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nombre, apellido) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
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
                cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"));
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

