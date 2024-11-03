package persistencia;


import Modelo.Platos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatosDao {

    private Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public PlatosDao(){
        try {
            this.con = Conexion.getInstance().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        }
    }

    public int IdPlato(){
        int id = 0;
        String query = "SELECT MAX(id) FROM platos";

        try (ResultSet resultSet = ps.executeQuery()){
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del plato: " + e.getMessage());
        }
        return id;
    }

    public int insertarPlato(Platos plato) {
        String sql = "INSERT INTO platos (id, nombre, precio, fecha) VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, plato.getId());
            ps.setString(2, plato.getNombre());
            ps.setDouble(3, plato.getPrecio());
            ps.setString(4, plato.getFecha());
            r = ps.executeUpdate();

            if (r > 0) {
                System.out.println("El plato con ID " + plato.getId() + " fue insertado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el plato: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }


    public int actualizarPlato(Platos plato) {
        String sql = "UPDATE platos SET nombre = ?, precio = ?, fecha = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, plato.getId());
            ps.setString(2, plato.getNombre());
            ps.setDouble(3, plato.getPrecio());
            ps.setString(4, plato.getFecha());
            r = ps.executeUpdate();

            if (r > 0) {
                System.out.println("El plato con ID " + plato.getId() + " fue modificado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el plato: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }

    public int eliminarPlato(int idPlato) {
        String sql = "DELETE FROM platos WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPlato);
            r = ps.executeUpdate();

            if (r > 0) {
                System.out.println("El plato con ID " + idPlato + " fue eliminado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el plato: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }


}
