package business.gestores;

import java.util.List;

import business.classes.AlumnadoDTO;
import business.classes.PlanesDeConvalidacionDTO;
import data.dao.AlumnadoDAO;
import data.dao.ProfesoradoDAO;

public class GestorAlumnado
{
    public static boolean crearAlumno(AlumnadoDTO nuevoUsuario, int idUsuario)
    {
    	return AlumnadoDAO.addStudent(nuevoUsuario, idUsuario);
    }

	public static List<PlanesDeConvalidacionDTO> mostrarPlanes() {
		
		return AlumnadoDAO.viewPlans();
		
	}
}