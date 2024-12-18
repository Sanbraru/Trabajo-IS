package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.classes.AlumnadoDTO;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;

public class AlumnadoDAO {
    
    public static boolean addStudent(AlumnadoDTO nuevoUsuario, int idUsuario) {
        boolean exito = false;

        // Usamos try-with-resources para cerrar los recursos automáticamente
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SqlProperties.getClave("sql.properties", "addStudent"))) {
            
            // Establecer los parámetros en la consulta
        	pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, nuevoUsuario.getTelefono());  // Teléfono (int)
            pstmt.setInt(3, nuevoUsuario.getAnioAcademico());  // Año Académico (int)
            pstmt.setString(4, nuevoUsuario.getCentroOrigen());  // Centro de Origen (String)
            pstmt.setInt(5, nuevoUsuario.isSolicitaAyuda() ? 1 : 0);  // Ayuda Económica (boolean -> int)
            pstmt.setInt(6, nuevoUsuario.isRealizado() ? 1 : 0);  // Plan SICUE realizado (boolean -> int)

            // Ejecutar la consulta de inserción
            int filasAfectadas = pstmt.executeUpdate();  // `executeUpdate()` se usa para INSERT, UPDATE, DELETE

            // Si se afectaron filas, la inserción fue exitosa
            if (filasAfectadas > 0) {
                exito = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }

        return exito;  // Devolver true si la inserción fue exitosa, false en caso contrario
    }

    public static void viewPlans() {
        // Cadena de conexión, consulta SQL, y conexión a la base de datos
        String sqlQuery = SqlProperties.getClave("sql.properties", "viewPlansStudents");
        
        // Abrir la conexión y ejecutar la consulta
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {
            
            // Establecer los parámetros en la consulta (si es necesario)
            pstmt.setInt(1, 1);  // Aquí deberías modificar el valor según lo que necesites para tu consulta

            // Ejecutar la consulta de selección
            ResultSet resultSet = pstmt.executeQuery();  // executeQuery() es usado para consultas SELECT

            // Mostrar los resultados
            System.out.println("Planes de Convalidación Disponibles:");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int tipoUsuario = resultSet.getInt("TipoUsuario");
                int tiempoPlan = resultSet.getInt("TiempoPlan");
                String centroDestino = resultSet.getString("CentroDestino");
                int asignaturaOrigen = resultSet.getInt("IdAsignaturasOrigen");
                int asignaturaDestino = resultSet.getInt("IdAsignaturasDestino");
                boolean vigente = resultSet.getBoolean("Vigente");
                int anoAcademico = resultSet.getInt("AnoAcademico");
                
                // Mostrar cada plan de convalidación
                System.out.println("ID: " + id + ", Tipo Usuario: " + tipoUsuario + ", Tiempo Plan: " + tiempoPlan +
                        ", Centro Destino: " + centroDestino + ", Asignatura Origen: " + asignaturaOrigen +
                        ", Asignatura Destino: " + asignaturaDestino + ", Vigente: " + vigente +
                        ", Año Académico: " + anoAcademico);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }
    }
}

