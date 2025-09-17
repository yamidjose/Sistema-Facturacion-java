package controlador;

import Coneccion.Connecion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.cliente;

public class ctrl_cliente {

    public boolean guardar(cliente objeto) {
        boolean respuesta = false;

        String sql = "INSERT INTO T_cliente VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, 0); // AUTO_INCREMENT
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellido());
            ps.setString(4, objeto.getCedula());
            ps.setString(5, objeto.getTelefono());
            ps.setString(6, objeto.getDireccion());
            ps.setInt(7, objeto.getEstado());

            respuesta = ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean existecliente(String cedula) {
        boolean respuesta = false;
        String sql = "SELECT cedula FROM T_cliente WHERE cedula = ?";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error al consultar cliente: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean actualizar(cliente objeto, int id_cliente) {
        boolean respuesta = false;

        String sql = "UPDATE T_cliente SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, direccion = ?, estado = ? WHERE id_cliente = ?";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getApellido());
            ps.setString(3, objeto.getCedula());
            ps.setString(4, objeto.getTelefono());
            ps.setString(5, objeto.getDireccion());
            ps.setInt(6, objeto.getEstado());
            ps.setInt(7, id_cliente);

            respuesta = ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean eliminar(int id_cliente) {
        boolean respuesta = false;
        String sql = "DELETE FROM T_cliente WHERE id_cliente = ?";

        try (Connection cn = new Connecion().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id_cliente);
            respuesta = ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }

        return respuesta;
    }
}

