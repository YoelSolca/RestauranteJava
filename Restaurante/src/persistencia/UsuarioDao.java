package persistencia;

import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection con;
    PreparedStatement ps;
    private ResultSet rs;
    int r = 0;



    public UsuarioDao() {
        try {
            this.con = Conexion.getInstance().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        }
    }

    public int insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPass());
            ps.setString(4, usuario.getRol());
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("El usuario fue insertado correctamente con ID " + usuario.getId());
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
        }
        return 0;
    }

    public int actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, pass = ?, rol = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPass());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getId());
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("El usuario con ID " + usuario.getId() + " fue actualizado correctamente.");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
        return 0;
    }

    public int eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("El usuario con ID " + id + " fue eliminado correctamente.");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return 0;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPass(rs.getString("pass"));
                usuario.setRol(rs.getString("rol"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
