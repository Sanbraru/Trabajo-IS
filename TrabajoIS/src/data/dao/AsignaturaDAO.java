package data.dao;

import business.classes.*;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList; 

public class AsignaturaDAO 
{
    
    public static boolean insertAsignatura(AsignaturaDTO n)
    {
        Boolean insertado = false;

        try 
        {

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlAsignatura.properties", "insertAsignatura");
            
            PreparedStatement pstmt = connection.prepareStatement(cola);


            pstmt.setInt(1, n.getID());

            // Set del tipo

            pstmt.setString(2, n.getNombre());

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

}
