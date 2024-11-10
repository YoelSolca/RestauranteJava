package persistence;

import model.Mesa;
import persistence.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MesaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
       public MesaDAO() {
        try{
            this.con = Conexion.getInstance().getConnection();
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public List<Mesa> ListarMesas() {
    List<Mesa> lista = new ArrayList<>();
    String consulta = "SELECT * FROM mesas WHERE estado = 'Libre' ORDER BY mesas ASC";
    
    try {
        ps = con.prepareStatement(consulta);
        rs = ps.executeQuery(); // Ejecuta la consulta y asigna el resultado a rs

        while (rs.next()) {
            Mesa pl = new Mesa();
            pl.setId(rs.getInt("id"));
            pl.setMesas(rs.getInt("mesas"));
            lista.add(pl);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar salones: " + e.toString());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.toString());
        }
    }
    return lista;
}
  
 public void actualizarEstado(String nuevoEstado, String numeroMesa) {
    String consulta = "UPDATE mesas SET estado = ? WHERE mesas = ?";
    
    try (PreparedStatement ps = con.prepareStatement(consulta)) {
        ps.setString(1, nuevoEstado);
        ps.setString(2, numeroMesa);  


        int filasActualizadas = ps.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("El estado de la mesa " + numeroMesa + " ha sido actualizado a " + nuevoEstado);
        } else {
            System.out.println("No se encontró ninguna mesa con el número especificado.");
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar el estado de la mesa: " + e.toString());
    }
}



}