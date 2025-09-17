package controlador;

import Coneccion.Connecion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Categoria;
import modelo.producto;

public class ctrl_producto {

    public boolean guardar(producto objeto) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO T_producto VALUES (?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setDouble(6, objeto.getPorcentaje_iva());
            consulta.setInt(7, objeto.getId_categoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();

        } catch (Exception e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        } finally {
            conexion.closeConnection();
        }

        return respuesta;
    }

    public boolean existeproducto(String producto) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM T_producto WHERE descripcion = '" + producto + "'";
        Statement st;

        try {
            Connecion conexion = new Connecion();
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                respuesta = true;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar producto: " + e.getMessage());
        }

        return respuesta;
    }

    // ✅ Nuevo método solo para actualizar la cantidad (stock)
    public boolean actualizarStock(int id_producto, int nuevaCantidad) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "UPDATE t_producto SET cantidad = ? WHERE id_producto = ?"
            );
            consulta.setInt(1, nuevaCantidad);
            consulta.setInt(2, id_producto);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el stock: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean actualizar(producto objeto, int id_producto) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "UPDATE t_producto SET nombre = ?, cantidad = ?, precio = ?, descripcion = ?, porcentaje_iva = ?, id_categoria = ?, estado = ? WHERE id_producto = ?"
            );

            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setDouble(5, objeto.getPorcentaje_iva());
            consulta.setInt(6, objeto.getId_categoria());
            consulta.setInt(7, objeto.getEstado());
            consulta.setInt(8, id_producto);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar los productos: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean eliminar(int id_producto) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "DELETE FROM t_producto WHERE id_producto = ?"
            );
            consulta.setInt(1, id_producto);

            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }

        return respuesta;
    }
}
