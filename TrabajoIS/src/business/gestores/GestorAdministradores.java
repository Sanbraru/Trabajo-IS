package business.gestores;
import java.util.ArrayList;

import business.classes.*;
import data.dao.PlanesDeConvalidacionDAO;
import data.dao.AsignaturaDAO;



public class GestorAdministradores
{

    public ArrayList<UsuarioDTO> buscarApuntados(int id)
    {
        ArrayList<UsuarioDTO> listaApuntados = null;

        return listaApuntados;
    }

    public boolean insertarPlan(PlanesDeConvalidacionDTO nuevoPlan)
    {

        if(!PlanesDeConvalidacionDAO.insertarPlanDAO(nuevoPlan))
        {
            return false;
        }
        
        return true;
    }
    
    public boolean insertarAsignatura(AsignaturaDTO n)
    {
        if(!AsignaturaDAO.insertAsignatura(n))
        {
            return false;
        }
        return true;
    }
}
