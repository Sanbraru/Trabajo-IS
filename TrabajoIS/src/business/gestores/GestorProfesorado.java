package business.gestores;

import business.classes.ProfesoradoDTO;
import data.dao.ProfesoradoDAO;

public class GestorProfesorado
{
    public static boolean crearProfesor(ProfesoradoDTO nuevoUsuario, int idUsuario)
    {
    	return ProfesoradoDAO.addTeacher(nuevoUsuario, idUsuario);
    }

	public static void mostrarPlanes() 
	{
		ProfesoradoDAO.viewPlans();
	}
}

