package business.gestores;

import java.util.List;

import business.classes.AlumnadoDTO;
import business.classes.AsignaturaDTO;
import business.classes.Plan_AsignaturasDTO;
import business.classes.PlanesDeConvalidacionDTO;
import data.dao.AlumnadoDAO;

public class GestorAlumnado
{
    public static boolean crearAlumno(AlumnadoDTO nuevoUsuario, int idUsuario)
    {
    	return AlumnadoDAO.addStudent(nuevoUsuario, idUsuario);
    }

	public static List<PlanesDeConvalidacionDTO> mostrarPlanes() {
		
		return AlumnadoDAO.viewPlans();
		
	}
	
	public static List<Plan_AsignaturasDTO> mostrarPlanesAsignaturas(int id) {
		
		return AlumnadoDAO.viewPlansAsignaturas(id);
		
	}
	
	public static List<AsignaturaDTO> mostrarAsignaturas(int id) {
		
		return AlumnadoDAO.viewAsignaturas(id);
		
	}
	
	public static void inscribirse(int n, String c)
	{
		AlumnadoDAO.apuntarse(n,c);
	}
}