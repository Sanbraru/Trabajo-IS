package data.dao;

import business.classes.*;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 


public class PlanesDeConvalidacionDAO {

    public static boolean insertarPlanDAO(PlanesDeConvalidacionDTO n)
    {

        Boolean insertado = false;

        try 
        {

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlMaterial.properties", "insertPlan");
            
            PreparedStatement pstmt = connection.prepareStatement(cola);


            pstmt.setInt(1, n.getId());

            pstmt.setBoolean(2, n.isTipoUsuario());

            pstmt.setInt(3, n.getTiempoPlan());

            pstmt.setString(4, n.getCentroDestino());

            pstmt.setBoolean(5, n.isVigente());
            
            pstmt.setInt(6, n.getAnioAcademico());

            //Con esto compruebas que se ha insertado el nuevo material
            int rowsAffected = pstmt.executeUpdate();
            insertado = rowsAffected > 0 && rowsAffected <= 1;

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e) 
        {
            System.err.println(e);
			e.printStackTrace();
        }


        return insertado;

    }

    public static boolean insertAsignaturaPlanOrigen(AsignaturaDTO n)
    {
        Boolean insertado = false;

        try 
        {

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlAsignatura.properties", "asignPlanOrigen");
            
            PreparedStatement pstmt = connection.prepareStatement(cola);


            pstmt.setInt(1, n.getID());

            //Con esto compruebas que se ha insertado el nuevo material
            int rowsAffected = pstmt.executeUpdate();
            insertado = rowsAffected > 0 && rowsAffected <= 1;

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e) 
        {
            System.err.println(e);
			e.printStackTrace();
        }


        return insertado;
    }
    public static boolean insertAsignaturaPlanDestino(AsignaturaDTO n)
    {
        Boolean insertado = false;

        try 
        {

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlAsignatura.properties", "asignPlanDestino");
            
            PreparedStatement pstmt = connection.prepareStatement(cola);


            pstmt.setInt(1, n.getID());

            //Con esto compruebas que se ha insertado el nuevo material
            int rowsAffected = pstmt.executeUpdate();
            insertado = rowsAffected > 0 && rowsAffected <= 1;

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e) 
        {
            System.err.println(e);
			e.printStackTrace();
        }


        return insertado;
    }

//     public static ArrayList<PlanesDeConvalidacionDTO> viewPlans() {

//         ArrayList<PlanesDeConvalidacionDTO> aux;

//         // Cadena de conexión, consulta SQL, y conexión a la base de datos
//         String sqlQuery = SqlProperties.getClave("sqlPlanesCONV.properties", "viewPlansStudents");
        
//         // Abrir la conexión y ejecutar la consulta
//         try (Connection connection = new DBConnection().getConnection();
//              PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {
            
//             // Establecer los parámetros en la consulta (si es necesario)
//             pstmt.setInt(1, 1);  // Aquí deberías modificar el valor según lo que necesites para tu consulta

//             // Ejecutar la consulta de selección
//             ResultSet resultSet = pstmt.executeQuery();  // executeQuery() es usado para consultas SELECT

//             // Mostrar los resultados
//             System.out.println("Planes de Convalidación Disponibles:");
//             while (resultSet.next()) {
//                 int id = resultSet.getInt("ID");
//                 int tipoUsuario = resultSet.getInt("TipoUsuario");
//                 int tiempoPlan = resultSet.getInt("TiempoPlan");
//                 String centroDestino = resultSet.getString("CentroDestino");
//                 int asignaturaOrigen = resultSet.getInt("IdAsignaturasOrigen");
//                 int asignaturaDestino = resultSet.getInt("IdAsignaturasDestino");
//                 boolean vigente = resultSet.getBoolean("Vigente");
//                 int anoAcademico = resultSet.getInt("AnoAcademico");
                
//                 //PlanesDeConvalidacionDTO plan = new PlanesDeConvalidacionDTO(id, tipoUsuario, tiempoPlan, centroDestino, null, null, vigente, anoAcademico);
//             }
            
//         } catch (SQLException e) {
//             e.printStackTrace();  // Imprimir el error si ocurre una excepción
//         }
//     }

}

// // Mostrar cada plan de convalidación
// System.out.println("ID: " + id + ", Tipo Usuario: " + tipoUsuario + ", Tiempo Plan: " + tiempoPlan +
// ", Centro Destino: " + centroDestino + ", Asignatura Origen: " + asignaturaOrigen +
// ", Asignatura Destino: " + asignaturaDestino + ", Vigente: " + vigente +
// ", Año Académico: " + anoAcademico);