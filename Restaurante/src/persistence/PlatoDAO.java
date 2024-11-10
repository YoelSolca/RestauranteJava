package persistence;

import model.Plato;
import persistence.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlatoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
       public PlatoDAO() {
        try{
            this.con = Conexion.getInstance().getConnection();
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertarPlato(Plato pla) {
        String sql = "INSERT INTO platos (nombre, precio, fecha) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pla.getNombre());
            ps.setDouble(2, pla.getPrecio());
            ps.setString(3, pla.getFecha());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally {
        }
    }

    public List Listar() {
        List<Plato> Lista = new ArrayList();
        String sql = "SELECT * FROM platos WHERE fecha = ?";
        String consulta = "SELECT * FROM platos";
        try {
            ps = con.prepareStatement(consulta);

            /*if(valor.equalsIgnoreCase("")){
                ps = con.prepareStatement(sql);
            }else{
                ps = con.prepareStatement(consulta);
            }*/
            //ps.setString(1, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                Plato pl = new Plato();
                pl.setId(rs.getInt("id"));
                pl.setNombre(rs.getString("nombre"));
                pl.setPrecio(rs.getDouble("precio"));
                Lista.add(pl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }

    public boolean eliminarPlato(int id) {
        String sql = "DELETE FROM platos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
        }
    }

    public boolean actualizarPlato(Plato pla) {
        String sql = "UPDATE platos SET nombre=?, precio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pla.getNombre());
            ps.setDouble(2, pla.getPrecio());
            ps.setInt(3, pla.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
        }
    }
}
