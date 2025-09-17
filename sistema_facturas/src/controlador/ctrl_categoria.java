package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Categoria;
import Coneccion.Connecion;
import java.sql.Statement;
import java.sql.ResultSet;

public class ctrl_categoria {

    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;

        Connecion conexion = new Connecion(); // Usa el tipo correcto
        Connection cn = conexion.getConnection(); // Llama el método

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into T_categoria values (?,?,?) ");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();

        } catch (Exception e) {
            System.out.println("Error al guardar la categoría: " + e.getMessage());
        } finally {
            conexion.closeConnection();
        }

        return respuesta;
    }

    public boolean existecategoria(String Categoria) {
        boolean respuesta = false;
        String sql = "SELECT descripcion FROM T_categoria WHERE descripcion = '" + Categoria + "';";
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
            System.out.println("Error al consultar categoría: " + e.getMessage());

            
        }

        return respuesta;
    }
//METODO PARA ACTUALIZAR LAS CATEGORIAS 

    public boolean actualizar(Categoria objeto, int id_categoria) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE t_categoria SET descripcion = ? WHERE id_categoria = ?"
            );

            consulta.setString(1, objeto.getDescripcion());
            consulta.setInt(2, id_categoria);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close(); // Opcional, pero recomendado si no usas pool

        } catch (Exception e) {
            System.out.println("Error al actualizar la categoría: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean eliminar(int id_categoria) {
        boolean respuesta = false;

        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();

        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM t_categoria WHERE id_categoria = ?");
            consulta.setInt(1, id_categoria);

            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas > 0) {
                respuesta = true;
            }

            consulta.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar la categoría: " + e.getMessage());
        }

        return respuesta;
    }

}
