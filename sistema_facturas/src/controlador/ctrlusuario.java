package controlador;

import Coneccion.Connecion;
import modelo.usuario;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ctrlusuario {

    public boolean guardar(usuario objeto) {
        boolean respuesta = false;
        Connection cn = new Connecion().getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO T_usuario  VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, 0);
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellido());
            ps.setString(4, objeto.getUsuario());
            ps.setString(5, objeto.getContraseña());
            ps.setString(6, objeto.getTelefono());
            ps.setInt(7, objeto.getEstado());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }

        return respuesta;
    }

  public boolean existeusuario(String usuario) {
    boolean respuesta = false;
    String sql = "SELECT usuario FROM t_usuario WHERE usuario = ?";

    try (Connection cn = new Connecion().getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            respuesta = true;
            System.out.println("usuario nuevo registrado");
        }

    } catch (Exception e) {
        System.out.println("Error al consultar usuario: " + e.getMessage());
    }

    return respuesta;
}


    public boolean loginUser(usuario objeto) {
        boolean respuesta = false;
        String sql = "SELECT usuario, contraseña FROM T_usuario WHERE usuario = ? AND contraseña = ?";

        try (Connection conn = new Connecion().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getContraseña());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        }

        return respuesta;
    }
    public boolean actualizar(usuario objeto, int id_usuario) {
        boolean respuesta = false;

        String sql = "UPDATE T_usuario SET nombre = ?, apellido = ?, usuario = ?, contraseña = ?, telefono = ?, estado = ? WHERE id_usuario = ?";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getApellido());
            ps.setString(3, objeto.getUsuario());
            ps.setString(4, objeto.getContraseña());
            ps.setString(5, objeto.getTelefono());
            ps.setInt(6, objeto.getEstado());
            ps.setInt(7, id_usuario);

            respuesta = ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean eliminar(int id_usuario) {
        boolean respuesta = false;
        String sql = "DELETE FROM T_usuario WHERE id_usuario = ?";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id_usuario);
            respuesta = ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }

        return respuesta;
    }
}
