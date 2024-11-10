package persistence;

import model.DetallePedido;
import model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
   
    public PedidoDAO() {
        try{
            this.con = Conexion.getInstance().getConnection();
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int verificarStado(int mesa, int id_sala) throws ClassNotFoundException{
        int id_pedido = 0;
        String sql = "SELECT id FROM pedidos WHERE num_mesa=? AND id_salon=? AND estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa);
            ps.setInt(2, id_sala);
            ps.setString(3, "PENDIENTE");
            rs = ps.executeQuery();
            if(rs.next()){
                id_pedido = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id_pedido;
    }
    
    public int RegistrarPedido(Pedido ped){
        String sql = "INSERT INTO pedidos (id_mesa, total) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getIdMesa());
            ps.setDouble(2, ped.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return r;
    }
    
    public int RegistrarDetalle(DetallePedido det){
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
    
    public List verPedidoDetalle(int id_pedido){
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
    
    public Pedido verPedido(int id_pedido){
        Pedido ped = new Pedido();
       String sql = "SELECT p.* FROM pedidos p INNER JOIN mesas s ON p.id_mesa = s.id WHERE p.id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id_pedido);
           rs = ps.executeQuery();
            if (rs.next()) {               
               
               ped.setId(rs.getInt("id"));
               ped.setFecha(rs.getString("fecha"));
               ped.setIdMesa(rs.getInt("id_mesa"));
               ped.setTotal(rs.getDouble("total"));
               ped.setEstado(rs.getString("estado"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ped;
   }
    
    public List finalizarPedido(int id_pedido) throws ClassNotFoundException{
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
    
    
    
    
    public boolean actualizarEstado (int id_pedido){
        String sql = "UPDATE pedidos SET estado = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "FINALIZADO");
            ps.setInt(2, id_pedido);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
public List<Pedido> listarPedidos() {
    List<Pedido> lista = new ArrayList<>();
    String sql = "SELECT p.* FROM pedidos p INNER JOIN mesas s ON p.id_mesa = s.id ORDER BY p.fecha DESC";

    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
         
        while (rs.next()) {
            Pedido ped = new Pedido();
            ped.setId(rs.getInt("id"));
            ped.setIdMesa(rs.getInt("id_mesa"));
            ped.setFecha(rs.getString("fecha"));
            ped.setTotal(rs.getDouble("total"));
            ped.setEstado(rs.getString("estado"));
            lista.add(ped);
        }
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    }
    return lista;
}

    
}
