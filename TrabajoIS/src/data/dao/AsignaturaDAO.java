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

    public static Boolean buscarPorID(int id)
    {

        Boolean encontrado = false;

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlAsignatura.properties", "selectAsignaturaPorID");

            PreparedStatement pstmt = connection.prepareStatement(cola);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs != null && rs.next())
            {

                encontrado = true;
            }
            else
            {
                encontrado = false;
            }

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e)
        {
            System.err.println(e);
			e.printStackTrace();
        }

        return encontrado;

    }
    
    public static ArrayList<AsignaturaDTO> requestAll()
    {
        ArrayList<AsignaturaDTO> aux = new ArrayList<>();

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlAsignatura.properties", "selectAll");

            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(cola);

            while(rs.next())
            {
                int idAsignatura = rs.getInt("idAsignatura");
                String nombre = rs.getString("nombreAsignatura");
                
                AsignaturaDTO nueva = new AsignaturaDTO(idAsignatura, nombre);

                aux.add(nueva);

            }

            stmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e)
        {
            System.err.println(e);
			e.printStackTrace();
        }

        return aux;
    }

    public static Boolean asignAsigPlan(Plan_AsignaturasDTO aux)
    {

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlPlan-Asignatura.properties", "asignAsignatura");

            PreparedStatement pstmt = connection.prepareStatement(cola);
            pstmt.setInt(3, aux.getIdAsignatura());

            pstmt.setInt(1, aux.getIdPlan());
            pstmt.setString(2, aux.getTipoAsignatura());
            
            int rowsAffected = pstmt.executeUpdate(); // Ejecuta la inserción
    
            if (rowsAffected > 0) {
                return true; // La pista fue creada exitosamente
            }

            pstmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión

    
        }
        catch (Exception e)
        {
            System.err.println(e);
			e.printStackTrace();
        }

        return false;


    }

}
