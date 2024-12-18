package business.gestores;

import business.classes.AlumnadoDTO;
import data.dao.AlumnadoDAO;
import data.dao.ProfesoradoDAO;

public class GestorAlumnado
{
    public static boolean crearAlumno(AlumnadoDTO nuevoUsuario, int idUsuario)
    {
    	return AlumnadoDAO.addStudent(nuevoUsuario, idUsuario);
    }

	public static void mostrarPlanes() {
		
		AlumnadoDAO.viewPlans();
		
	}
}