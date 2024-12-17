package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.classes.UsuarioDTO;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;

public class ProfesoradoDAO {

    public static boolean addTeacher(UsuarioDTO nuevoUsuario)
    {
        boolean exito = false;

        // Usamos try-with-resources para asegurar el cierre de recursos automáticamente
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SqlProperties.getClave("sql.properties", "addTeacher"))) {
            
            // Establecer los parámetros en la consulta
            pstmt.setString(1, nuevoUsuario.getCorreo());
            pstmt.setString(2, nuevoUsuario.getContrasena());
            pstmt.setString(3, nuevoUsuario.getNombre());
            pstmt.setString(4, nuevoUsuario.getApellidos());
            pstmt.setString(5, nuevoUsuario.getDni());

            // Ejecutar la consulta de inserción
            int filasAfectadas = pstmt.executeUpdate();  // executeUpdate() se usa para operaciones de modificación (INSERT, UPDATE, DELETE)

            // Si se afectaron filas, la inserción fue exitosa
            if (filasAfectadas > 0) {
                exito = true;  // La inserción fue exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }

        return exito;  // Devolver true si la inserción fue exitosa, false en caso contrario
    }
    
}
