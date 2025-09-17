package Coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecion {

    // Constantes para los datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_ventas?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"; // URL de la base de datos
    private static final String USER = "root"; // Usuario de la base de datos
    private static final String PASSWORD = "12345678"; // Contraseña de la base de datos

    private Connection activa = null; // Objeto Connection

    // Método para obtener la conexión
    public Connection getConnection() {
        if (activa == null) { // Verificar si la conexión no está activa
            try {
                // A partir de JDBC 4.0 no es necesario llamar a Class.forName,
                // pero lo mantenemos por compatibilidad
                Class.forName("com.mysql.cj.jdbc.Driver");
                activa = DriverManager.getConnection(URL, USER, PASSWORD); // Establecer la conexión
                System.out.println("Conexión exitosa con la base de datos");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: No se encontró el driver de MySQL. " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error: No se pudo conectar a la base de datos. " + e.getMessage());
            }
        }
        return activa;
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        if (activa != null) {
            try {
                activa.close();
                activa = null; // Asegurar que el objeto sea nulo después de cerrar la conexión
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
