package business.gestores;
import java.util.ArrayList;

import business.classes.*;
import data.dao.PlanesDeConvalidacionDAO;
import data.dao.UsuarioDAO;
import data.dao.AsignaturaDAO;



public class GestorAdministradores
{

    public static ArrayList<UsuarioDTO> obtenerUsuarios(int ID)
    {
        return UsuarioDAO.requestIdPlan(ID);
    }

    public static boolean insertarPlan(PlanesDeConvalidacionDTO nuevoPlan)
    {
       
        if(PlanesDeConvalidacionDAO.insertarPlanDAO(nuevoPlan))
        {
            return true;
        }
                
        return false;
    }
    
    public static boolean insertarAsignatura(AsignaturaDTO n)
    {
        if(!AsignaturaDAO.insertAsignatura(n))
        {
            return false;
        }
        return true;
    }
    public static Boolean buscarAsignatura(int id)
    {
        return AsignaturaDAO.buscarPorID(id);
    }

    public static Boolean buscarPlan(int id)
    {
        return PlanesDeConvalidacionDAO.buscarPorID(id);
    }

    public static ArrayList<AsignaturaDTO> obtenerAsignaturas()
    {
        return AsignaturaDAO.requestAll();
    }

    public static Boolean asignarAsignaturaAPlan(Plan_AsignaturasDTO nueva)
    {

        return AsignaturaDAO.asignAsigPlan(nueva);

    }

    public static ArrayList<PlanesDeConvalidacionDTO> obtenerPlanes()
    {
        return PlanesDeConvalidacionDAO.requestPlanes();
    }

    public static Boolean modificarVigencia(int ID)
    {
        return PlanesDeConvalidacionDAO.setVigente(ID);
    }
}
