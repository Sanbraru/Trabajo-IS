package data.dao;

import business.classes.*;
import data.common.conection.DBConnection;
import data.common.sql.SqlProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


            pstmt.setInt(1, n.getIdMaterial());

            // Set del tipo

            String tipostr = n.getTipo().toString();
            pstmt.setString(2, tipostr);

            // Set de el uso exterior
            pstmt.setBoolean(3, n.isUsoExterior());

            // Set del estado
            String estadostr = n.getEstado().toString();
            pstmt.setString(4, estadostr);

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
