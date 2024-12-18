package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.classes.ProfesoradoDTO;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;

public class ProfesoradoDAO {

    public static  boolean addTeacher(ProfesoradoDTO nuevoUsuario, int idUsuario) {
        boolean exito = false;

        // Usamos try-with-resources para asegurar el cierre de recursos automáticamente
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SqlProperties.getClave("sql.properties", "addTeacher"))) {

            // Establecer los parámetros en la consulta
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, nuevoUsuario.getTelefono());
            pstmt.setString(3, nuevoUsuario.getCentroOrigen());
            
            // Convertir los valores booleanos a 1 (true) o 0 (false)
            pstmt.setInt(4, nuevoUsuario.isSolicitaAyuda() ? 1 : 0);  // 1 para verdadero, 0 para falso
            pstmt.setInt(5, nuevoUsuario.isRealizado() ? 1 : 0);       // 1 para verdadero, 0 para falso

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
