package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.classes.AlumnadoDTO;
import business.classes.AsignaturaDTO;
import business.classes.Plan_AsignaturasDTO;
import business.classes.PlanesDeConvalidacionDTO;
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

    public static List<PlanesDeConvalidacionDTO> viewPlans() {
        // Cadena de conexión, consulta SQL, y conexión a la base de datos
        String sqlQuery = SqlProperties.getClave("sql.properties", "viewPlansStudents");
        List<PlanesDeConvalidacionDTO> planes = new ArrayList<>();

        // Abrir la conexión y ejecutar la consulta
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {

            // Establecer los parámetros en la consulta (si es necesario)
            pstmt.setInt(1, 1);  // Aquí deberías modificar el valor según lo que necesites para tu consulta

            // Ejecutar la consulta de selección
            ResultSet resultSet = pstmt.executeQuery();  // executeQuery() es usado para consultas SELECT

       
            while (resultSet.next()) {
                // Obtener los valores de cada columna en el ResultSet
                int id = resultSet.getInt("ID");
                boolean tipoUsuario = resultSet.getBoolean("TipoUsuario");
                int tiempoPlan = resultSet.getInt("TiempoPlan");
                String centroDestino = resultSet.getString("CentroDestino");
                boolean vigente = resultSet.getBoolean("Vigente");
                int anoAcademico = resultSet.getInt("AnoAcademico");

                // Crear un nuevo objeto PlanesDeConvalidacionDTO
                PlanesDeConvalidacionDTO plan = new PlanesDeConvalidacionDTO(id, tipoUsuario, tiempoPlan, centroDestino, vigente, anoAcademico);

                // Añadir el plan a la lista
                planes.add(plan);

            }

        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }

        // Retornar la lista de planes
        return planes;
    }
    
    public static List<Plan_AsignaturasDTO> viewPlansAsignaturas(int id_P) {
        // Cadena de conexión, consulta SQL, y conexión a la base de datos
        String sqlQuery = SqlProperties.getClave("sql.properties", "viewPlansAsignaturas");
        List<Plan_AsignaturasDTO> planes = new ArrayList<>();

        // Abrir la conexión y ejecutar la consulta
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {

            // Establecer los parámetros en la consulta (si es necesario)
            pstmt.setInt(1, id_P);  // Aquí deberías modificar el valor según lo que necesites para tu consulta

            // Ejecutar la consulta de selección
            ResultSet resultSet = pstmt.executeQuery();  // executeQuery() es usado para consultas SELECT

            // Mostrar los resultados
            while (resultSet.next()) {
                // Obtener los valores de cada columna en el ResultSet
            	
                int id_A = resultSet.getInt("id_asignatura");
                String tipo_A = resultSet.getString("tipo_asignatura");


                // Crear un nuevo objeto PlanesDeConvalidacionDTO
                Plan_AsignaturasDTO plan = new Plan_AsignaturasDTO(id_P, id_A, tipo_A);

                // Añadir el plan a la lista
                planes.add(plan);

            }

        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }

        // Retornar la lista de planes
        return planes;
    }
    
    public static List<AsignaturaDTO> viewAsignaturas(int id) {
        // Cadena de conexión, consulta SQL, y conexión a la base de datos
        String sqlQuery = SqlProperties.getClave("sql.properties", "viewAsignaturas");
        List<AsignaturaDTO> planes = new ArrayList<>();

        // Abrir la conexión y ejecutar la consulta
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {

            // Establecer los parámetros en la consulta (si es necesario)
            pstmt.setInt(1, id);  // Aquí deberías modificar el valor según lo que necesites para tu consulta

            // Ejecutar la consulta de selección
            ResultSet resultSet = pstmt.executeQuery();  // executeQuery() es usado para consultas SELECT


            while (resultSet.next()) {

                String nombreAs = resultSet.getString("nombreAsignatura");

                // Crear un nuevo objeto PlanesDeConvalidacionDTO
                AsignaturaDTO plan = new AsignaturaDTO(id, nombreAs);

                // Añadir el plan a la lista
                planes.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Imprimir el error si ocurre una excepción
        }

        // Retornar la lista de planes
        return planes;
    }
}

