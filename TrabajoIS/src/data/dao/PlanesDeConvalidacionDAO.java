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
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "insertPlan");
            
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
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "asignPlanOrigen");
            
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
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "asignPlanDestino");
            
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

    public static ArrayList<PlanesDeConvalidacionDTO> requestPlanes()
    {

        ArrayList<PlanesDeConvalidacionDTO> listaPlanes = new ArrayList<>();

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "requestPlanes");

            PreparedStatement pstmt = connection.prepareStatement(cola);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs != null && rs.next())
            {

                String nombreAsignatura = rs.getString("nombreAsignatura");
            
                nuevo = new AsignaturaDTO(id, nombreAsignatura);

            }
            else
            {
                nuevo = null;
            }

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e)
        {
            System.err.println(e);
			e.printStackTrace();
        }

        return listaPlanes;
    }

}

