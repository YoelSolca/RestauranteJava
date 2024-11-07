package persistence;

import model.DetallePedido;
import model.Pedidos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO {
    private Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;


    public PedidosDAO() {
        try {
            this.con = Conexion.getInstance().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
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


    public int RegistrarPedido(Pedidos ped) {
        String sql = "INSERT INTO pedidos (id_salon, num_mesa, total, usuario) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getId_salon());
            ps.setInt(2, ped.getNum_mesa());
            ps.setDouble(3, ped.getTotal());
            ps.setString(4, ped.getUsuario());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }

    public int RegistrarDetalle(DetallePedido det) {
        String sql = "INSERT INTO detalle_pedidos (nombre, precio, cantidad, comentario, id_pedido) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, det.getNombre());
            ps.setDouble(2, det.getPrecio());
            ps.setInt(3, det.getCantidad());
            ps.setString(4, det.getComentario());
            ps.setInt(5, det.getId_pedido());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return r;
    }

    public List verPedidoDetalle(int id_pedido) {
        List<DetallePedido> Lista = new ArrayList();
        String sql = "SELECT d.* FROM pedidos p INNER JOIN detalle_pedidos d ON p.id = d.id_pedido WHERE p.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido det = new DetallePedido();
                det.setId(rs.getInt("id"));
                det.setNombre(rs.getString("nombre"));
                det.setPrecio(rs.getDouble("precio"));
                det.setCantidad(rs.getInt("cantidad"));
                det.setComentario(rs.getString("comentario"));
                Lista.add(det);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }

    public Pedidos verPedido(int id_pedido) {
        Pedidos ped = new Pedidos();
        String sql = "SELECT p.*, s.nombre FROM pedidos p INNER JOIN salones s ON p.id_salon = s.id WHERE p.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            rs = ps.executeQuery();
            if (rs.next()) {

                ped.setId(rs.getInt("id"));
                ped.setFecha(rs.getString("fecha"));
                ped.setSalon(rs.getString("nombre"));
                ped.setNum_mesa(rs.getInt("num_mesa"));
                ped.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ped;
    }

    public List listarPedidos() {
        List<Pedidos> Lista = new ArrayList();
        String sql = "SELECT p.*, s.nombre FROM pedidos p INNER JOIN salones s ON p.id_salon = s.id ORDER BY p.fecha DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedidos ped = new Pedidos();
                ped.setId(rs.getInt("id"));
                ped.setSalon(rs.getString("nombre"));
                ped.setNum_mesa(rs.getInt("num_mesa"));
                ped.setFecha(rs.getString("fecha"));
                ped.setTotal(rs.getDouble("total"));
                ped.setUsuario(rs.getString("usuario"));
                ped.setEstado(rs.getString("estado"));
                Lista.add(ped);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }

}
