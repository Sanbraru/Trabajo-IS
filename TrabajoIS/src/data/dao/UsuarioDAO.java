package data.dao;

import java.sql.*;

import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;

public class UsuarioDAO {

    public static int loginUsuario(String sesion, String password) {
        int id = 0; // Inicializa el id con 0 (significa que no se encontró al usuario)
        
        // Usamos try-with-resources para asegurar el cierre de recursos automáticamente
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SqlProperties.getClave("sql.properties", "loginUsuario"))) {
            
            // Establecer los parámetros de la consulta
            pstmt.setString(1, sesion);  // Establecer el parámetro de sesión (Correo)
            pstmt.setString(2, password);  // Establecer el parámetro de contraseña

            // Ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                // Verificar si se encontró un resultado y obtener el idUsuario
                if (rs.next()) {
                    id = rs.getInt("idUsuario");  // Asignar el idUsuario encontrado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }
        
        return id;  // Devolver el id del usuario (o 0 si no se encontró)
    }
    
    public static String searchID(int Id) {
        String rol = null;

        // Usamos try-with-resources para asegurar el cierre de recursos automáticamente
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SqlProperties.getClave("sql.properties", "searchID"))) {
            
            // Establecer el parámetro de ID
            pstmt.setInt(1, Id);  // Establecer el parámetro de ID

            // Ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                // Verificar si se encontró un resultado y obtener el rol
                if (rs.next()) {
                    rol = rs.getString("Rol");  // Obtener el rol del usuario
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }
        
        return rol;  // Devolver el rol del usuario (o null si no se encontró)
    }
}
