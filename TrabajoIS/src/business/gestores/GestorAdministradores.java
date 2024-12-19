package business.gestores;
import java.util.ArrayList;

import business.classes.*;
import data.dao.PlanesDeConvalidacionDAO;
import data.dao.UsuarioDAO;
import data.dao.AsignaturaDAO;



public class GestorAdministradores
{

    //Funcion que devuelve los usuarios apuntados a cierto Plan de convalidacion

    public static ArrayList<UsuarioDTO> obtenerUsuarios(int ID)
    {
        return UsuarioDAO.requestIdPlan(ID);
    }

    //Funcion que inserta un nuevo Plan de conavlidacion en la base de datos

    public static boolean insertarPlan(PlanesDeConvalidacionDTO nuevoPlan)
    {
       
        if(PlanesDeConvalidacionDAO.insertarPlanDAO(nuevoPlan))
        {
            return true;
        }
                
        return false;
    }
    
    //Funcion que inserta una nueva asignatura en la base de datos

    public static boolean insertarAsignatura(AsignaturaDTO n)
    {
        if(!AsignaturaDAO.insertAsignatura(n))
        {
            return false;
        }
        return true;
    }

    //Funcion que devuelve true si ha encontrado la asignatura o no

    public static Boolean buscarAsignatura(int id)
    {
        return AsignaturaDAO.buscarPorID(id);
    }

    //Funcion que,  al contrario de la de arriba, si que devuelve la asignatura en si

    public static AsignaturaDTO buscarAsignatura2(int ID)
    {

        return AsignaturaDAO.buscarPorID2(ID);

    }

    //Funcion que busca un plan de convalidacion por su ID

    public static Boolean buscarPlan(int id)
    {
        return PlanesDeConvalidacionDAO.buscarPorID(id);
    }

    //Funcion que devuelve todas las asignaturas existentes

    public static ArrayList<AsignaturaDTO> obtenerAsignaturas()
    {
        return AsignaturaDAO.requestAll();
    }

    //Funcion que asigna una asignatura existente a un plan existente

    public static Boolean asignarAsignaturaAPlan(Plan_AsignaturasDTO nueva)
    {

        return AsignaturaDAO.asignAsigPlan(nueva);

    }

    //Funcion que devuelve todos los plaes de convalidacion existentes

    public static ArrayList<PlanesDeConvalidacionDTO> obtenerPlanes()
    {
        return PlanesDeConvalidacionDAO.requestPlanes();
    }

    //Funcion que pone un plan de convalidacion como no vigente

    public static Boolean modificarVigencia(int ID)
    {
        return PlanesDeConvalidacionDAO.setVigente(ID);
    }

    //Funcion que busca las asignaturas vinculadas a un plan

    public static ArrayList<Plan_AsignaturasDTO> buscarAsignaturasDePlan(int ID)
    {
        return AsignaturaDAO.buscarEnlaces(ID);
    }
}
