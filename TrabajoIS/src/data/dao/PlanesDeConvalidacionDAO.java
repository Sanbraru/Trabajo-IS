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

    //Funcion que inserta un plan de convalidacion en la base de datos

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
            if(rowsAffected > 0)
            {
                insertado = true;
            }

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

    //Funcion que devuelve un array con todos los planes existentes

    public static ArrayList<PlanesDeConvalidacionDTO> requestPlanes()
    {

        ArrayList<PlanesDeConvalidacionDTO> listaPlanes = new ArrayList<>();

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "requestPlanes");

            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(cola);

            while(rs.next())
            {
                int idPlan = rs.getInt("idPlan");
                Boolean tipoUsuario = rs.getBoolean("tipoUsuario");
                int tiempoPlan = rs.getInt("TiempoPlan");
                String centroDestino = rs.getString("CentroDestino");
                Boolean vigente = rs.getBoolean("Vigente");
                int anoAcademico = rs.getInt("AnoAcademico");

                PlanesDeConvalidacionDTO nuevo = new PlanesDeConvalidacionDTO(idPlan, tipoUsuario, tiempoPlan, centroDestino, vigente, anoAcademico);

                listaPlanes.add(nuevo);

            }

            stmt.close(); // Cierra el PreparedStatement
            dbConnection.closeConnection(); // Cierra la conexión
    
        }
        catch (Exception e)
        {
            System.err.println(e);
			e.printStackTrace();
        }

        return listaPlanes;
    }

    //Funcion que devuelve modifica el valor del campo vigente a false

    public static Boolean setVigente(int ID)
    {

        Boolean insertado = false;

        try 
        {

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "setVigencia");
            
            PreparedStatement pstmt = connection.prepareStatement(cola);


            pstmt.setInt(1, ID);

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

    //Funcion que busca un Plan de convalidacion por su ID

    public static Boolean buscarPorID(int id)
    {

        Boolean encontrado = false;

        try
        {
            
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String cola = SqlProperties.getClave("sqlPlanesCONV.properties", "selectPlanPorID");

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

}

