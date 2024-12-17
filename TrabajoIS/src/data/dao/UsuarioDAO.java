package data.dao;

import java.sql.*;

import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;
import com.mysql.jdbc.ResultSet;

public class UsuarioDAO {
    
    public static String loginUsuario(String sesion, String password) {
        String rol = null;
        
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            
            // Obtener la consulta SQL desde un archivo de propiedades
            String query = SqlProperties.getClave("sql.properties", "loginUsuario");
            
            // Preparar la consulta SQL
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, sesion);
            pstmt.setString(2, password);
            
            // Ejecutar la consulta
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            
            // Verificar si se encontró un resultado y obtener el rol
            if (rs.next()) {
                rol = rs.getString("Rol");
            }
            
            // Cerrar recursos
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            dbConnection.closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();  // Es buena práctica imprimir el error si ocurre una excepción
        }
        
        return rol;  // Devolver el rol (o null si no se encontró)
    }
}
