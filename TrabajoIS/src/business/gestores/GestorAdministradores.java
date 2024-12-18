package business.gestores;
import java.util.ArrayList;

import business.classes.*;
import data.dao.PlanesDeConvalidacionDAO;
import data.dao.AsignaturaDAO;



public class GestorAdministradores
{

    public static ArrayList<UsuarioDTO> buscarApuntados(int id)
    {
        ArrayList<UsuarioDTO> listaApuntados = null;

        if((listaApuntados = PlanesDeConvalidacionDAO.requestApuntados(id)) != null)
        {

            return listaApuntados;

        }

        return listaApuntados;
    }

    public static boolean insertarPlan(PlanesDeConvalidacionDTO nuevoPlan)
    {

        if(nuevoPlan.getTiempoPlan() <=0 || nuevoPlan.getTiempoPlan() < 10 )
        {
            return false;
        }
        else if(nuevoPlan.getCentroDestino() == "\0")
        {
            return false;
        }
        else if(nuevoPlan.getAnioAcademico() < 2024)
        {
            return false;
        }
        else if(!PlanesDeConvalidacionDAO.insertarPlanDAO(nuevoPlan))
        {
            return false;
        }

        
        return true;
    }
    
    public static boolean insertarAsignatura(AsignaturaDTO n)
    {
        if(!AsignaturaDAO.insertAsignatura(n))
        {
            return false;
        }
        return true;
    }
    public static AsignaturaDTO buscarAsignatura(int id)
    {
        return AsignaturaDAO.buscarPorID(id);
    }
}
