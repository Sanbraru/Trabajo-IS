package business.gestores;

import java.util.List;

import business.classes.AsignaturaDTO;
import business.classes.Plan_AsignaturasDTO;
import business.classes.PlanesDeConvalidacionDTO;
import business.classes.ProfesoradoDTO;
import data.dao.ProfesoradoDAO;

public class GestorProfesorado
{
    public static boolean crearProfesor(ProfesoradoDTO nuevoUsuario, int idUsuario)
    {
    	return ProfesoradoDAO.addTeacher(nuevoUsuario, idUsuario);
    }

	public static List<PlanesDeConvalidacionDTO> mostrarPlanes() {
		
		return ProfesoradoDAO.viewPlans();
		
	}
	
	public static List<Plan_AsignaturasDTO> mostrarPlanesAsignaturas(int id) {
		
		return ProfesoradoDAO.viewPlansAsignaturas(id);
		
	}
	
	public static List<AsignaturaDTO> mostrarAsignaturas(int id) {
		
		return ProfesoradoDAO.viewAsignaturas(id);
		
	}
	
	public static void inscribirse(int n, String c)
	{
		ProfesoradoDAO.apuntarse(n,c);
	}
}

