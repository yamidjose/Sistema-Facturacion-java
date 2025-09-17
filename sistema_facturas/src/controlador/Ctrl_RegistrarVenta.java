package controlador;

import Coneccion.Connecion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date; // Asegúrate de importar esto
import modelo.cabecera_ventas;
import modelo.detalle_venta;

/**
 * @author edison
 */
public class Ctrl_RegistrarVenta {

    // Último ID registrado en cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;

    /**
     * **************************************************
     * Método para guardar la cabecera de venta
     * **************************************************
     */
    public boolean guardar(cabecera_ventas objeto) {
        boolean respuesta = false;
        Connecion conexion = new Connecion(); 
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "INSERT INTO T_cabecera (id_cliente, valor_pagar, fecha_venta, estado) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            // No incluimos el id_cabecera porque es AUTO_INCREMENT
            consulta.setInt(1, objeto.getId_cliente());
            consulta.setDouble(2, objeto.getValor_pagar());
            consulta.setDate(3, objeto.getFecha_venta()); // usamos setDate directamente
            consulta.setInt(4, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            // Obtener el ID generado
            ResultSet rs = consulta.getGeneratedKeys();
            if (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }

        return respuesta;
    }

    /**
     * **************************************************
     * Método para guardar el detalle de venta
     * **************************************************
     */
    public boolean guardarDetalle(detalle_venta objeto) {
        boolean respuesta = false;
        Connecion conexion = new Connecion(); 
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "INSERT INTO T_detalle_venta VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            consulta.setInt(1, 0); // id_detalle_venta, AUTO_INCREMENT
            consulta.setInt(2, idCabeceraRegistrada); // id_cabecera_venta
            consulta.setInt(3, objeto.getId_producto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotal_pagar());
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }

        return respuesta;
    }
        public boolean actualizar(cabecera_ventas objeto, int id_cabeceraventa) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE t_cabecera SET id_cliente = ?, estado = ? WHERE id_cabecera = '" + id_cabeceraventa + "'");

            consulta.setInt(1, objeto.getId_cliente());
            consulta.setInt(2, objeto.getEstado()); // id de la cabecera a actualizar

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar la cabecera de venta: " + e.getMessage());
        }

        return respuesta;
    }
}
